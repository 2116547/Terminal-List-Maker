package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Board bord = new Board();
        Command command = new Command(bord);
        bord.drawBoard();

        // Runs the program until the user enters an empty command
        while (true) {
            String context = scanner.nextLine();
            if (context.isEmpty()) {
                break;
            } else if (context.charAt(0) == '/'){
                if (context.equals("/clear")){
                    command.clearBoard();
                } else if (context.equals("/help")){
                    command.printCommands();
                } else if (context.contains("/remove")){
                    command.removeItem(context);
                } else if (context.equals("/size")){
                    command.getSize();
                } else if (context.contains("/settitle")) {
                    command.changeTitle(context);
                } else if (context.equals("/quit")){
                    break;
                }


                else {
                    System.out.println("Command not found, tye /help for the list of commands");
                }
            } else {
                bord.newLine(context);
            }
        }
    }
}
