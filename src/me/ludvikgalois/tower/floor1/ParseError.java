package me.ludvikgalois.tower.floor1;

/**
 * Created by probie on 8/11/16.
 * We'd probably like better error reporting, but it's not needed and I don't really feel
 * like spending the time on it
 */
public class ParseError extends Exception{

    public int characterNumber;
    public ParseError(int characterNumber){
        this.characterNumber = characterNumber;
    }
}
