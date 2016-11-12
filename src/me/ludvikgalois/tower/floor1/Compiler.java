package me.ludvikgalois.tower.floor1;

import me.ludvikgalois.tower.floor0.Commands;
import me.ludvikgalois.tower.utils.Counter;

import java.util.ArrayList;

/**
 * Created by probie on 8/11/16.
 */
public class Compiler {
    private Commands[] outputProgram;
    private Command[] inputProgram;

    public Compiler(Command[] inputProgram) {
        this.inputProgram = inputProgram;
    }

    public Commands[] compile() {
        // If we've already compiled it once, don't do it again
        if (outputProgram != null) return outputProgram;
        ArrayList<Commands> prog = new ArrayList();

        for (Command c: inputProgram)
            switch (c.getTag()) {
                case ZERO: // [-]
                    prog.add(Commands.WHILE);
                    prog.add(Commands.DEC);
                    prog.add(Commands.END);
                    break;
                case WHILE:
                    prog.add(Commands.WHILE);
                    break;
                case END:
                    prog.add(Commands.END);
                    break;
                case IN:
                    prog.add(Commands.IN);
                    break;
                case OUT:
                    prog.add(Commands.OUT);
                    break;
                default:
                    assert (c instanceof  ValuedCommand);
                    ValuedCommand vc = (ValuedCommand) c; // Safe to do here
                    Commands baseInstruction = vc.baseInstruction();
                    new Counter(vc.getValue()).doTimes(() -> prog.add(baseInstruction));
                    /*
                    switch (vc.getTag()) {
                        case INC:
                            new Counter(vc.getValue()).doTimes(() -> prog.add(Commands.INC));
 //                           for (int i : new Counter(vc.getValue())) prog.add(Commands.INC);
                            break;
                        case DEC:
                            for (int i : new Counter(vc.getValue())) prog.add(Commands.DEC);
                            break;
                        case NEXT:
                            for (int i : new Counter(vc.getValue())) prog.add(Commands.NEXT);
                            break;
                        case PREV:
                            for (int i : new Counter(vc.getValue())) prog.add(Commands.PREV);
                            break;
                        default:
                            break; // Shouldn't happen, but just in case
                    }
                    */

            }
        outputProgram = prog.stream().toArray(Commands[]::new);
        return outputProgram;
    }

}
