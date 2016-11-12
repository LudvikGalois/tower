package me.ludvikgalois.tower.floor1;

/**
 * Created by probie on 8/11/16.
 * What I wouldn't give for something like the Haskell
 * data Command = Zero | Inc Int | Dec Int | Next Int | Prev Int | While | End | In | Out
 * Ideally commands without values should be singletons, but that doesn't work
 * properly with inheritance unless I do something stupid like an interface that
 * parametrises on its own class
 */
public abstract class Command {
    public abstract CommandTag getTag();
}
