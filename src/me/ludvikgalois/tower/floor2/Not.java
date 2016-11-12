package me.ludvikgalois.tower.floor2;

import me.ludvikgalois.tower.utils.Counter;

import java.util.ArrayList;

/**
 * Created by probie on 9/11/16.
 */
public class Not extends Command{

    public Not(){}

    @Override
    public ArrayList<me.ludvikgalois.tower.floor1.Command> codeGen(){
        ArrayList<me.ludvikgalois.tower.floor1.Command> prog = new ArrayList();
        // Move to sub-cell 2
        prog.add(new me.ludvikgalois.tower.floor1.Next(Constants.WORD_SIZE));
        // Set sub-cell 2 to all ones
        for (int i : new Counter(Constants.WORD_SIZE)){
            prog.add(new me.ludvikgalois.tower.floor1.Inc(1));
            prog.add(new me.ludvikgalois.tower.floor1.Next(1));
        }
        prog.add(new me.ludvikgalois.tower.floor1.Prev(2*Constants.WORD_SIZE));
        // Negate sub cell 2 as needed
        for (int i : new Counter(Constants.WORD_SIZE)){
            prog.add(new me.ludvikgalois.tower.floor1.While());
            prog.add(new me.ludvikgalois.tower.floor1.Next(Constants.WORD_SIZE));
            prog.add(new me.ludvikgalois.tower.floor1.Zero());
            prog.add(new me.ludvikgalois.tower.floor1.Prev(Constants.WORD_SIZE));
            prog.add(new me.ludvikgalois.tower.floor1.Zero());
            prog.add(new me.ludvikgalois.tower.floor1.End());
            prog.add(new me.ludvikgalois.tower.floor1.Next(1));
        }
        //prog.add(new me.ludvikgalois.tower.floor1.Prev(Constants.WORD_SIZE));
        // Copy sub cell 2 into sub cell 1
        for (int i : new Counter(Constants.WORD_SIZE)){
            prog.add(new me.ludvikgalois.tower.floor1.While());
            prog.add(new me.ludvikgalois.tower.floor1.Prev(Constants.WORD_SIZE));
            prog.add(new me.ludvikgalois.tower.floor1.Inc(1));
            prog.add(new me.ludvikgalois.tower.floor1.Next(Constants.WORD_SIZE));
            prog.add(new me.ludvikgalois.tower.floor1.Zero());
            prog.add(new me.ludvikgalois.tower.floor1.End());
            prog.add(new me.ludvikgalois.tower.floor1.Next(1));
        }
        prog.add(new me.ludvikgalois.tower.floor1.Prev(2*Constants.WORD_SIZE));
        return prog;
    }

}
