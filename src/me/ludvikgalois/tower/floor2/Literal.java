package me.ludvikgalois.tower.floor2;

import me.ludvikgalois.tower.floor1.Inc;
import me.ludvikgalois.tower.floor1.Next;
import me.ludvikgalois.tower.floor1.Prev;
import me.ludvikgalois.tower.floor1.Zero;
import me.ludvikgalois.tower.utils.Counter;

import java.util.ArrayList;

/**
 * Created by probie on 9/11/16.
 * A literal
 */
public class Literal {
    private int value;
    public Literal (int value){
        this.value = value;
    }

    public ArrayList<me.ludvikgalois.tower.floor1.Command> codeGen(){
        ArrayList<me.ludvikgalois.tower.floor1.Command> prog = new ArrayList();
        for (int i : new Counter(Constants.WORD_SIZE)) {
            prog.add(new Zero());
            if ((value & 1<<i) != 0) {
                prog.add(new Inc(1));
            }
            prog.add(new me.ludvikgalois.tower.floor1.Next(1));
        }
        prog.add(new me.ludvikgalois.tower.floor1.Prev(Constants.WORD_SIZE));
        return prog;
    }

}
