package me.ludvikgalois.tower.floor1;

/**
 * Created by probie on 8/11/16.
 */
public class Prev extends ValuedCommand {
    @Override
    public CommandTag getTag() {
        return CommandTag.PREV;
    }

    public Prev(int value){
        super(value);
    }
}
