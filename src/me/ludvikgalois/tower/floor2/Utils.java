package me.ludvikgalois.tower.floor2;

import me.ludvikgalois.tower.floor1.*;
import me.ludvikgalois.tower.utils.Counter;

import java.util.ArrayList;

/**
 * Created by probie on 11/13/16.
 */
public class Utils {

    private static ArrayList<me.ludvikgalois.tower.floor1.Command> oneThreeCopy;

    // We want to end up with our value in sub cells 1 and 3
    public static ArrayList<me.ludvikgalois.tower.floor1.Command> oneThreeCopy(){
        if (oneThreeCopy != null) return oneThreeCopy;
        oneThreeCopy = new ArrayList();
        // Copy into cell 2
        new Counter(Constants.WORD_SIZE).doTimes(() -> {
            oneThreeCopy.add(new While());
            oneThreeCopy.add(new Dec(1));
            oneThreeCopy.add(new me.ludvikgalois.tower.floor1.Next(Constants.WORD_SIZE));
            oneThreeCopy.add(new Inc(1));
            oneThreeCopy.add(new me.ludvikgalois.tower.floor1.Prev(Constants.WORD_SIZE));
            oneThreeCopy.add(new End());
            oneThreeCopy.add(new me.ludvikgalois.tower.floor1.Next(1));
        });

        new Counter(Constants.WORD_SIZE).doTimes(() -> {
            oneThreeCopy.add(new While());
            oneThreeCopy.add(new Dec(1));
            oneThreeCopy.add(new me.ludvikgalois.tower.floor1.Next(Constants.WORD_SIZE));
            oneThreeCopy.add(new Inc(1));
            oneThreeCopy.add(new me.ludvikgalois.tower.floor1.Prev(2*Constants.WORD_SIZE));
            oneThreeCopy.add(new Inc(1));
            oneThreeCopy.add(new me.ludvikgalois.tower.floor1.Next(Constants.WORD_SIZE));
            oneThreeCopy.add(new End());
            oneThreeCopy.add(new me.ludvikgalois.tower.floor1.Next(1));
        });
        oneThreeCopy.add(new me.ludvikgalois.tower.floor1.Prev(2*Constants.WORD_SIZE));

        return oneThreeCopy;
    }

    public static ValuedCommand calculateShift(int offset) {
        return offset >= 0
                ? new me.ludvikgalois.tower.floor1.Next(offset * Constants.WORD_SIZE * Constants.CELL_SIZE)
                : new me.ludvikgalois.tower.floor1.Prev(offset * Constants.WORD_SIZE * Constants.CELL_SIZE * -1);
    }
}
