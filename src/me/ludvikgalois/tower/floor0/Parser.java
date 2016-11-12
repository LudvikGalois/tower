package me.ludvikgalois.tower.floor0;

import java.util.ArrayList;

/**
 * Created by probie on 8/11/16.
 * A simple parser for brainfuck
 */
public class Parser {
    private String sourceCode;
    private Commands[] program;

    public Parser (String sourceCode){
        this.sourceCode = sourceCode;
    }

    public Commands[] parse() {
        // If we've already parsed it, don't do it again
        if (program != null) return program;

        ArrayList<Commands> prog = new ArrayList();
        for (char c : sourceCode.toCharArray()) {
            switch (c) {
                case '+': prog.add(Commands.INC); break;
                case '-': prog.add(Commands.DEC); break;
                case '>': prog.add(Commands.NEXT); break;
                case '<': prog.add(Commands.PREV); break;
                case ',': prog.add(Commands.IN); break;
                case '.': prog.add(Commands.OUT); break;
                case '[': prog.add(Commands.WHILE); break;
                case ']': prog.add(Commands.END); break;
                default: break; // A comment
            }
        }
        program = prog.stream().toArray(Commands[]::new);
        return program;
    }
}
