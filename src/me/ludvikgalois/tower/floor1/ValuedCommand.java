package me.ludvikgalois.tower.floor1;

/**
 * Created by probie on 8/11/16.
 */
public abstract class ValuedCommand extends Command {
    private int value;

    public ValuedCommand(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
