package com.company;

import java.util.ArrayList;

public class Board{
    String lineBottom = "╚══════════════════════════════════╝";
    ArrayList<BoardLine> lines = new ArrayList<>();
    BoardLine listTitle = new BoardLine("List");

    public void newLine(String content){
        BoardLine line = new BoardLine();
        fillLine(line, content);
        lines.add(line);
        drawBoard();
    }

    public void fillLine(BoardLine line, String content){
        // Board is 36 chars wide, max content width is 34
        line.setContent(content);
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

    public int getLinesCount(){
        return lines.size();
    }

    public void drawBoard(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("╔══════════════════════════════════╗");
        System.out.println(listTitle.getContent());
        System.out.println("╠══════════════════════════════════╣");
        printLines(lines);
        System.out.println(lineBottom);
    }

    public void setBoardTitle(String title){
        listTitle.setContent(title);
        drawBoard();
    }

    public void clearBoard(){
        int i = 0;
        while (lines.size() > i){
            lines.remove(0);
        }
        drawBoard();
    }
}
