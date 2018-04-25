package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Board bord = new Board();
        bord.drawBoard();

        while (true) {
            String context = scanner.nextLine();
            if (context.isEmpty()) {
                break;
            } else if (context.charAt(0) == '/'){
                if (context.equals("/clear")){
                    bord.clearBoard();
                } else if (context.equals("/help")){

                } else if (context.contains("/remove")){

                    if (context.length() == 7){
                        System.out.println("Please specify the line you want to remove");
                    } else {
                        String search = context.substring(8);
                        bord.removeLine(search);
                    }
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
