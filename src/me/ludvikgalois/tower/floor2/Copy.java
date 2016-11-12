package me.ludvikgalois.tower.floor2;

import me.ludvikgalois.tower.floor1.Parser;
import me.ludvikgalois.tower.utils.Counter;

import java.util.ArrayList;

/**
 * Created by probie on 9/11/16.
 */
public class Copy extends Command {
    private final int offset;

    public Copy (int offset){
        this.offset = offset;
    }

    @Override
    public ArrayList<me.ludvikgalois.tower.floor1.Command> codeGen() {
        ArrayList<me.ludvikgalois.tower.floor1.Command> prog = new ArrayList();
        // Copy into other 2 sub cells
        for (int i : new Counter(Constants.WORD_SIZE)) {
            prog.add(new me.ludvikgalois.tower.floor1.While());
            prog.add(new me.ludvikgalois.tower.floor1.Next(Constants.WORD_SIZE));
            prog.add(new me.ludvikgalois.tower.floor1.Zero());
            prog.add(new me.ludvikgalois.tower.floor1.Inc(1));
            prog.add(new me.ludvikgalois.tower.floor1.Next(Constants.WORD_SIZE));
            prog.add(new me.ludvikgalois.tower.floor1.Zero());
            prog.add(new me.ludvikgalois.tower.floor1.Inc(1));
            prog.add(new me.ludvikgalois.tower.floor1.Prev(2*Constants.WORD_SIZE));
            prog.add(new me.ludvikgalois.tower.floor1.Zero());
            prog.add(new me.ludvikgalois.tower.floor1.End());
            prog.add(new me.ludvikgalois.tower.floor1.Next(1));
        }

        // Point at second sub cell

        // Copy from sub cell 2 back into sub cell 1
        for (int i : new Counter(Constants.WORD_SIZE)) {
            prog.add(new me.ludvikgalois.tower.floor1.While());
            prog.add(new me.ludvikgalois.tower.floor1.Prev(Constants.WORD_SIZE));
            prog.add(new me.ludvikgalois.tower.floor1.Zero());
            prog.add(new me.ludvikgalois.tower.floor1.Inc(1));
            prog.add(new me.ludvikgalois.tower.floor1.Next(Constants.WORD_SIZE));
            prog.add(new me.ludvikgalois.tower.floor1.Zero());
            prog.add(new me.ludvikgalois.tower.floor1.End());
            prog.add(new me.ludvikgalois.tower.floor1.Next(1));
        }
        // Point at third sub cell

        // Copy from sub cell 3 into resulting cell
        if (offset > 0) {
            int cellOffset = Constants.WORD_SIZE + (offset - 1) * Constants.WORD_SIZE * Constants.CELL_SIZE;
            for (int i : new Counter(Constants.WORD_SIZE)) {
                prog.add(new me.ludvikgalois.tower.floor1.While());
                prog.add(new me.ludvikgalois.tower.floor1.Next(cellOffset));
                prog.add(new me.ludvikgalois.tower.floor1.Zero());
                prog.add(new me.ludvikgalois.tower.floor1.Inc(1));
                prog.add(new me.ludvikgalois.tower.floor1.Prev(cellOffset));
                prog.add(new me.ludvikgalois.tower.floor1.Zero());
                prog.add(new me.ludvikgalois.tower.floor1.End());
                prog.add(new me.ludvikgalois.tower.floor1.Next(1));
            }
        } else if (offset < 0) {
            int cellOffset = 2 * Constants.WORD_SIZE + (-1 * offset) * Constants.WORD_SIZE * Constants.CELL_SIZE;
            for (int i : new Counter(Constants.WORD_SIZE)) {
                prog.add(new me.ludvikgalois.tower.floor1.While());
                prog.add(new me.ludvikgalois.tower.floor1.Prev(cellOffset));
                prog.add(new me.ludvikgalois.tower.floor1.Zero());
                prog.add(new me.ludvikgalois.tower.floor1.Inc(1));
                prog.add(new me.ludvikgalois.tower.floor1.Next(cellOffset));
                prog.add(new me.ludvikgalois.tower.floor1.Zero());
                prog.add(new me.ludvikgalois.tower.floor1.End());
                prog.add(new me.ludvikgalois.tower.floor1.Next(1));
            }
        }
        prog.add(new me.ludvikgalois.tower.floor1.Prev(Constants.WORD_SIZE*3));
        return prog;
    }

}
