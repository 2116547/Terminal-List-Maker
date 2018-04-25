package com.company;

class BoardLine {

    private String content = "";
    private String text = "";

    BoardLine(String content){
        setContent(content);
    }

    BoardLine(){

    }

    String getContent() {
        return content;
    }

    String getText() {
        return text;
    }

    void setContent(String content) {
        if (content.length() <= 34){
            this.content = TransformContent(content);
            this.text = content;
        } else {
            System.err.println("Error: content to big. Length: " + content.length());
        }
    }

    private String TransformContent(String c){
        String transformed = "";
        String cont = "";
        int length = c.length();
        int spaces = (34 - length) / 2;
        int spacesTotal = 34 - length;
        int i = 1;

        while (spaces >= i) {
            cont = cont + " ";
            i++;
        }

        if ((spacesTotal & 1) == 0){
            i = 1;
        } else {
            i = 0;
        }

        cont = cont + c;


        while (spaces >= i) {
            cont = cont + " ";
            i++;
        }


        transformed = "║" + cont + "║";
        return transformed;
    }
}
