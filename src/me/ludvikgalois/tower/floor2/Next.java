package me.ludvikgalois.tower.floor2;

import java.util.ArrayList;

/**
 * Created by probie on 9/11/16.
 */
public class Next extends Command {
    private int value;

    public Next (int value){
        this.value = value;
    }

    @Override
    public ArrayList<me.ludvikgalois.tower.floor1.Command> codeGen(){
        ArrayList<me.ludvikgalois.tower.floor1.Command> res = new ArrayList();
        res.add(new me.ludvikgalois.tower.floor1.Next(value*Constants.CELL_SIZE*Constants.WORD_SIZE));
        return res;
    }

}
