package com.company;

class Command {
    private Board board = new Board();

    Command(Board b){
        this.board = b;
    }

    void clearBoard(){
        board.clearBoard();
    }

    void removeItem(String s){
        if (s.length() == 7){
            System.out.println("Please specify the line you want to remove");
        } else {
            String search = s.substring(8);
            board.removeLine(search);
        }
    }

    void changeTitle(String t){
        if (t.length() <= 10){
            System.out.println("Please specify a new title for the list");
        } else {
            String title = t.substring(10);
            board.setBoardTitle(title);
        }
    }

    void getSize(){
        System.out.println("List size: " + board.getLinesCount());
    }

    void printCommands(){
        System.out.println("/clear - clears the list");
        System.out.println("/remove [list item] - removes specified list item");
        System.out.println("/settitle [title] - replaces the title of the list");
        System.out.println("/size - gives the size of the current list");
        System.out.println("/quit - quits the program");
    }
}
