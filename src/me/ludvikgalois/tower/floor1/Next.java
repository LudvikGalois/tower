package me.ludvikgalois.tower.floor1;

import me.ludvikgalois.tower.floor0.Commands;

/**
 * Created by probie on 8/11/16.
 */
public class Next extends ValuedCommand{
    @Override
    public CommandTag getTag() {
        return CommandTag.NEXT;
    }

    public Next(int value){
        super(value);
    }

    @Override
    public Commands baseInstruction() {
        return Commands.NEXT;
    }

}
