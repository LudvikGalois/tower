package me.ludvikgalois.tower.floor2;

import java.util.ArrayList;

/**
 * Created by probie on 9/11/16.
 */
public class Prev extends Command{

    private int value;

    public Prev(int value){
        this.value = value;
    }

    @Override
    public ArrayList<me.ludvikgalois.tower.floor1.Command> codeGen(){
        ArrayList<me.ludvikgalois.tower.floor1.Command> res = new ArrayList();
        res.add(new me.ludvikgalois.tower.floor1.Prev(value*Constants.CELL_SIZE*Constants.WORD_SIZE));
        return res;
    }

}
