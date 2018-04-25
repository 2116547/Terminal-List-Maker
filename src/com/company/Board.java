package com.company;

import java.util.ArrayList;

public class Board{
    String lineBottom = "╚══════════════════════════════════╝";
    ArrayList<BoardLine> lines = new ArrayList<>();

    public void newLine(String content){
        BoardLine line = new BoardLine();
        fillLine(line, content);
        lines.add(line);
        drawBoard();
    }

    public void fillLine(BoardLine line, String content){
        // Board is 36 chars wide, max content width is 34
        int length = content.length();

        if (length <= 34){
            line.setContent(content);
        } else {
            System.err.println("Error: content to big. Length: " + length);
        }
    }

    public void removeLine(String s){
        boolean found = false;
        for (BoardLine l : lines){
            if(l.getText().equals(s)){
                found = true;
                lines.remove(lines.indexOf(l));
                drawBoard();
            }
        }
        if (found == false){
            System.err.println("Error: line: " + s + " not found");
        }
        found = false;
    }

    public void printLine(BoardLine line){
        System.out.println(line.getContent());
    }

    public void printLines(ArrayList<BoardLine> list){
        for (BoardLine l : list){
            printLine(l);
        }
    }

    public void drawBoard(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("╔══════════════════════════════════╗");
        BoardLine l1 = new BoardLine("Olé Olé Olé");
        System.out.println(l1.getContent());
        BoardLine l2 = new BoardLine("Dikke tieten kartofelsalat");
        System.out.println(l2.getContent());
        System.out.println("╠══════════════════════════════════╣");
        printLines(lines);
        System.out.println(lineBottom);
    }

    public void clearBoard(){
        int i = 0;
        while (lines.size() > i){
            lines.remove(0);
        }
        drawBoard();
    }
}
