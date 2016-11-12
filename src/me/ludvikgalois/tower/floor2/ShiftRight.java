package me.ludvikgalois.tower.floor2;

import me.ludvikgalois.tower.utils.Counter;

import java.util.ArrayList;

/**
 * Created by probie on 9/11/16.
 * Technically we shift left, but since people aren't going to look
 * at our backwards numbers we give the operation that's equivalent to n>>1
 */
public class ShiftRight extends Command{

    public ShiftRight(){}

    @Override
    public ArrayList<me.ludvikgalois.tower.floor1.Command> codeGen(){
        ArrayList<me.ludvikgalois.tower.floor1.Command> prog = new ArrayList();
        prog.add(new me.ludvikgalois.tower.floor1.Zero());
        prog.add(new me.ludvikgalois.tower.floor1.Next(1));
        for (int i : new Counter(Constants.WORD_SIZE - 1 )) {
            prog.add(new me.ludvikgalois.tower.floor1.While());
            prog.add(new me.ludvikgalois.tower.floor1.Prev(1));
            prog.add(new me.ludvikgalois.tower.floor1.Inc(1));
            prog.add(new me.ludvikgalois.tower.floor1.Next(1));
            prog.add(new me.ludvikgalois.tower.floor1.Zero());
            prog.add(new me.ludvikgalois.tower.floor1.End());
            prog.add(new me.ludvikgalois.tower.floor1.Next(1));
        }
        prog.add(new me.ludvikgalois.tower.floor1.Prev(Constants.WORD_SIZE));
        return prog;
    }

}
