package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Board bord = new Board();
        bord.drawBoard();

        // Runs the program until the user enters an empty command
        while (true) {
            String context = scanner.nextLine();
            if (context.isEmpty()) {
                break;
            } else if (context.charAt(0) == '/'){
                if (context.equals("/clear")){
                    bord.clearBoard();
                } else if (context.equals("/help")){
                    System.out.println("/clear - clears the list");
                    System.out.println("/remove [list item] - removes specified list item");
                    System.out.println("/settitle [title] - Replaces the title of the list");
                } else if (context.contains("/remove")){
                        if (context.length() == 7){
                        System.out.println("Please specify the line you want to remove");
                    } else {
                        String search = context.substring(8);
                        bord.removeLine(search);
                    }
                } else if (context.equals("/size")){
                    System.out.println("List size: " + bord.getLinesCount());
                } else if (context.contains("/settitle")){
                    if (context.length() == 8){
                        System.out.println("Please specify a new title for the list");
                    } else {
                        String title = context.substring(10);
                        bord.setBoardTitle(title);
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
