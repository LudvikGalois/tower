package me.ludvikgalois.tower.floor1;

import java.util.ArrayList;

/**
 * Created by probie on 8/11/16.
 * A parser for a slightly more advanced version of brainfuck
 */
public class Parser {

    private String sourceCode;
    private Command[] program;

    public Parser(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    // This little language has no comments
    // Z means set to zero
    // n+ means increment by n
    // n- means decrement by n
    // n> means move forward by n
    // n< means move back by n
    // [],. characters have normal meaning
    public Command[] parse() throws ParseError {
        if (program != null) return program; // Only need to evaluate once
        ArrayList<Command> prog = new ArrayList();
        int index = 0;
        int oldIndex = index;
        int count;
        while (index < sourceCode.length()) {
            if (Character.isDigit(sourceCode.charAt(index))) {
                // If it's a number, find the end of the number
                oldIndex = index;
                try {
                    while (Character.isDigit(sourceCode.charAt(index))) index++;
                    count = Integer.parseInt(sourceCode.substring(oldIndex, index));
                    // We've found the end of the number, so now parse the command
                    switch (sourceCode.charAt(index)){
                        case '+':
                            prog.add(new Inc(count));
                            break;
                        case '-':
                            prog.add(new Dec(count));
                            break;
                        case '>':
                            prog.add(new Next(count));
                            break;
                        case '<':
                            prog.add(new Prev(count));
                            break;
                        default:
                            throw new ParseError(index);
                    }
                } catch (StringIndexOutOfBoundsException e){
                    throw new ParseError(index);
                }
            } else switch (sourceCode.charAt(index)) {
                case 'Z':
                    prog.add(new Zero());
                    break;
                case '[':
                    prog.add(new While());
                    break;
                case ']':
                    prog.add(new End());
                    break;
                case '.':
                    prog.add(new Out());
                    break;
                case ',':
                    prog.add(new In());
                    break;
                default:
                    throw new ParseError(index);
            }
            index++;
        }
        program = new Command[prog.size()];
        prog.toArray(program);
        return program;
    }

}
