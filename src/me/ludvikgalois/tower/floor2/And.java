package me.ludvikgalois.tower.floor2;

import me.ludvikgalois.tower.floor1.*;
import me.ludvikgalois.tower.utils.Counter;

import java.util.ArrayList;

/**
 * Created by probie on 11/13/16.
 */
public class And extends Command {

   private final int offset;

    public And (int offset) {this.offset = offset;}

    @Override
    public ArrayList<me.ludvikgalois.tower.floor1.Command> codeGen() {
        ArrayList<me.ludvikgalois.tower.floor1.Command> prog = new ArrayList();
        // Select other cell
        prog.add(Utils.calculateShift(offset));
        // make a copy of it in sub-cell 3
        prog.addAll(Utils.oneThreeCopy());
        // select sub cell 3
        prog.add(new me.ludvikgalois.tower.floor1.Next(2*Constants.WORD_SIZE));
        new Counter(Constants.WORD_SIZE).doTimes(() -> {
            // If the bit is off in this word, set the corresponding bit
            // to off in the other word
            prog.add(new Dec(1));
            prog.add(new While());
            prog.add(new me.ludvikgalois.tower.floor1.Prev(2*Constants.WORD_SIZE));
            prog.add(Utils.calculateShift(-offset));
            prog.add(new Zero());
            prog.add(Utils.calculateShift(offset));
            prog.add(new me.ludvikgalois.tower.floor1.Next(2*Constants.WORD_SIZE));
            // For efficiency, a "positive" zero
            prog.add(new While());
            prog.add(new Inc(1));
            prog.add(new End());
            prog.add(new End());
            prog.add(new me.ludvikgalois.tower.floor1.Next(1));
        });
        // Select sub cell 1
        prog.add(new me.ludvikgalois.tower.floor1.Prev(3*Constants.WORD_SIZE));
        // Move back to start
        prog.add(Utils.calculateShift(-offset));
        return prog;
    }


}
