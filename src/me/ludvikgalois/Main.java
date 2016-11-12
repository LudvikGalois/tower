package me.ludvikgalois;

import me.ludvikgalois.tower.floor0.Commands;
import me.ludvikgalois.tower.floor0.Interpreter;
import me.ludvikgalois.tower.floor1.Command;
import me.ludvikgalois.tower.floor1.Compiler;
import me.ludvikgalois.tower.floor1.ParseError;
import me.ludvikgalois.tower.floor1.Parser;
import me.ludvikgalois.tower.floor2.Constants;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Parser parser = new Parser("72+.Z105+.");
        try {
            Command[] res = parser.parse();
            ArrayList<Command> progList = new ArrayList();
            /*
            progList.addAll(new me.ludvikgalois.tower.floor2.Literal(10).codeGen());
            progList.addAll(new me.ludvikgalois.tower.floor2.Print().codeGen());
            progList.addAll(new me.ludvikgalois.tower.floor2.Next(1).codeGen());
            progList.addAll(new me.ludvikgalois.tower.floor2.Literal(7).codeGen());
            progList.addAll(new me.ludvikgalois.tower.floor2.Copy(2).codeGen());
            progList.addAll(new me.ludvikgalois.tower.floor2.Copy(-1).codeGen());
            progList.addAll(new me.ludvikgalois.tower.floor2.Not().codeGen());
            progList.addAll(new me.ludvikgalois.tower.floor2.Prev(1).codeGen());
            progList.addAll(new me.ludvikgalois.tower.floor2.ShiftRight().codeGen());
            progList.addAll(new me.ludvikgalois.tower.floor2.Next(1).codeGen());
            progList.addAll(new me.ludvikgalois.tower.floor2.Or(-1).codeGen());
            */
            progList.addAll(new me.ludvikgalois.tower.floor2.Literal(5).codeGen());
            progList.addAll(new me.ludvikgalois.tower.floor2.Next(1).codeGen());
            progList.addAll(new me.ludvikgalois.tower.floor2.Literal(6).codeGen());
            progList.addAll(new me.ludvikgalois.tower.floor2.And(-1).codeGen());
            res = new Command[progList.size()];
            progList.toArray(res);
            Commands[] program = new Compiler(res).compile();
            Interpreter interpreter = new Interpreter(program, 5000);
            char mem[] = interpreter.run();
            for (int i = 0; i < 4; i ++){
                for (int j = 0; j < 3; j ++) {
                    System.out.println("Cell " + i + " subcell " + j);
                    for (int k = 0; k < 24; k++) {
                        System.out.print((int) mem[i* Constants.WORD_SIZE*Constants.CELL_SIZE + j * Constants.WORD_SIZE + k] + " ");
                    }
                    System.out.println();
                }
            }
        } catch (ParseError e){
            System.out.println("Parse error at: " + e.characterNumber);
            System.exit(1);
        } catch (IOException e){
            System.out.println("IO Exception occurred");
            System.exit(1);
        }

    }
}
