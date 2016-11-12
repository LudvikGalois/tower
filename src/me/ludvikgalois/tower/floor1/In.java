package me.ludvikgalois.tower.floor1;

/**
 * Created by probie on 8/11/16.
 */
public class In extends Command {
    @Override
    public CommandTag getTag() {
        return CommandTag.IN;
    }

    public In() {}
}
