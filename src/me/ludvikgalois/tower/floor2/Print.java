package me.ludvikgalois.tower.floor2;

import me.ludvikgalois.tower.utils.Counter;

import java.util.ArrayList;

/**
 * Created by probie on 9/11/16.
 * A destructive print
 */
public class Print extends Command {
    public Print() {}

    @Override
    public ArrayList<me.ludvikgalois.tower.floor1.Command> codeGen(){
        ArrayList<me.ludvikgalois.tower.floor1.Command> prog = new ArrayList();
        assert (Constants.WORD_SIZE>=9);
        prog.add(new me.ludvikgalois.tower.floor1.Next(8));
        prog.add(new me.ludvikgalois.tower.floor1.Zero());
        prog.add(new me.ludvikgalois.tower.floor1.Prev(8));
        for (int i : new Counter(8)) {
            prog.add(new me.ludvikgalois.tower.floor1.While());
            prog.add(new me.ludvikgalois.tower.floor1.Next(8 - i));
            prog.add(new me.ludvikgalois.tower.floor1.Inc((int) Math.pow(2,i)));
            prog.add(new me.ludvikgalois.tower.floor1.Prev(8 - i));
            prog.add(new me.ludvikgalois.tower.floor1.Zero());
            prog.add(new me.ludvikgalois.tower.floor1.End());
            prog.add(new me.ludvikgalois.tower.floor1.Next(1));
        }
        prog.add(new me.ludvikgalois.tower.floor1.Out());
        prog.add(new me.ludvikgalois.tower.floor1.Prev(8));
        return prog;
    }

}
