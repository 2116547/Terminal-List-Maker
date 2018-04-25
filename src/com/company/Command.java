package com.company;

import java.util.ArrayList;

public class Command {
    String command = "";
    ArrayList<Command> commands = new ArrayList<>();

    public Command (String c){
        this.command = c;
    }

    public void printCommands(){
        for (Command c : commands){
            System.out.println(command);
        }
    }
}
