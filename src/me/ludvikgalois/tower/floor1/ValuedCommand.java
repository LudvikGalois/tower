package me.ludvikgalois.tower.floor1;

import me.ludvikgalois.tower.floor0.Commands;

/**
 * Created by probie on 8/11/16.
 */
public abstract class ValuedCommand extends Command {
    private final int value;

    public ValuedCommand(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public abstract Commands baseInstruction();


}
