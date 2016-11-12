package me.ludvikgalois.tower.floor1;

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
}
