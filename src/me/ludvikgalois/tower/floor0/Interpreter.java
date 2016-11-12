package me.ludvikgalois.tower.floor0;

import java.io.IOError;
import java.io.IOException;

/**
 * Created by probie on 8/11/16.
 */
public class Interpreter {
    private Commands[] program;
    private char[] memory;
    private int currentCell = 0;
    private int currentInstruction = 0;

    public Interpreter (Commands[] program, int cells) {
        this.program = program;
        memory = new char[cells];
    }

    public char[] run() throws IOException {
        int depth;
        while (currentInstruction < program.length) {
            switch (program[currentInstruction]) {
                case INC:
                    memory[currentCell]++;
                    break;
                case DEC:
                    memory[currentCell]--;
                    break;
                case NEXT:
                    currentCell++;
                    break;
                case PREV:
                    currentCell--;
                    break;
                case IN:
                    memory[currentCell] = (char) System.in.read();
                    break;
                case OUT:
                    System.out.print(memory[currentCell]);
                    break;
                case WHILE:
                    if (memory[currentCell] != 0) break;
                    depth = 1; // Number of nested whiles
                    // Scan for end (only needs to be done once), otherwise END handles it
                    while (depth > 0) {
                        currentInstruction++;
                        switch (program[currentInstruction]){
                            case WHILE: depth++; break;
                            case END: depth--; break;
                            default: break;
                        }
                    }
                    break;
                case END:
                    if (memory[currentCell] == 0) break;
                    // Scan back for start
                    depth = 1; //number of nested whiles
                    while (depth > 0) {
                        currentInstruction--;
                        switch (program[currentInstruction]){
                            case WHILE: depth--; break;
                            case END: depth++; break;
                            default: break;
                        }
                    }
                    break;
            }
            currentInstruction++;
        }
        return memory;

    }
}
