package me.ludvikgalois.tower.floor1;

/**
 * Created by probie on 8/11/16.
 */
public class While extends Command {
    @Override
    public CommandTag getTag() {
        return CommandTag.WHILE;
    }

    public While() {}

}
