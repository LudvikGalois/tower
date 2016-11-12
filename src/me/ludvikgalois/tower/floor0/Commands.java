package me.ludvikgalois.tower.floor0;

/**
 * Created by probie on 8/11/16.
 * The instructions used in brainfuck
 */
public enum Commands {

    INC("+"), DEC("-"), NEXT(">"), PREV("<"), WHILE("["), END("]"), IN(","), OUT(".");

    private String representation;

    Commands(String representation){
        this.representation = representation;
    }

    @Override
    public String toString(){
        return this.representation;
    }
}
