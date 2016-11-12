package me.ludvikgalois.tower.floor1;

/**
 * Created by probie on 8/11/16.
 */
public class Dec extends ValuedCommand {
    @Override
    public CommandTag getTag() {
        return CommandTag.DEC;
    }

    public Dec (int value) {
        super(value);
    }

}
