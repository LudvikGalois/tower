package me.ludvikgalois.tower.floor1;

/**
 * Created by probie on 8/11/16.
 */
public class Inc extends ValuedCommand {
    @Override
    public CommandTag getTag() {
        return CommandTag.INC;
    }

    public Inc(int value){
        super(value);
    }


}
