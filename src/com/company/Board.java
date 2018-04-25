package com.company;

import java.util.ArrayList;

class Board {
    String lineBottom = "╚══════════════════════════════════╝";
    private ArrayList<BoardLine> lines = new ArrayList<>();
    private BoardLine listTitle = new BoardLine("List");

    void newLine(String content){
        BoardLine line = new BoardLine();
        fillLine(line, content);
        lines.add(line);
        drawBoard();
    }

    private void fillLine(BoardLine line, String content){
        // Board is 36 chars wide, max content width is 34
        line.setContent(content);
    }

    void removeLine(String s){
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

    private void printLine(BoardLine line){
        System.out.println(line.getContent());
    }

    private void printLines(ArrayList<BoardLine> list){
        for (BoardLine l : list){
            printLine(l);
        }
    }

    int getLinesCount(){
        return lines.size();
    }

    void drawBoard(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("╔══════════════════════════════════╗");
        System.out.println(listTitle.getContent());
        System.out.println("╠══════════════════════════════════╣");
        printLines(lines);
        System.out.println(lineBottom);
    }

    void setBoardTitle(String title){
        listTitle.setContent(title);
        drawBoard();
    }

    void clearBoard(){
        int i = 0;
        while (lines.size() > i){
            lines.remove(0);
        }
        drawBoard();
    }
}
