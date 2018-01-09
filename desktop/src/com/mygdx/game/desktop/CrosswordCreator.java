package com.mygdx.game.desktop;

import java.util.Scanner;

public class CrosswordCreator {

    public static char crossword[][];

    public static void main(String[] args){
        sizeChoosing();
        Scanner done_adding = new Scanner(System.in);
        //char[][] crossword_grid = sizeChoosing();
        //do {
            addLetter();
        //} while (done_adding.match("done");
        getCrossword();
    }

    public static char[][] sizeChoosing(){
        Scanner input = new Scanner(System.in);
        System.out.println("Choose size of crossword in range 3 to 15 ! ");
        System.out.print("Rows : ");
        int rows = Integer.parseInt(input.next());
        System.out.print("Columns : ");
        int columns = Integer.parseInt(input.next());
        crossword = new char[rows][columns];
        return crossword;
    }

    public static char[][] addLetter(){
        Scanner addletter = new Scanner(System.in);
        System.out.println("Enter position of letter.");
        System.out.print("Row: ");
        int rows = Integer.parseInt(addletter.next());
        System.out.print("Column: ");
        int columns = Integer.parseInt(addletter.next());
        System.out.print("Letter: ");
        char letter = addletter.next(".").charAt(0);
        crossword[rows][columns] = letter;
        return crossword;
    }

    public static char[][] getCrossword(){
        for (int i = 0; i < crossword.length; i++){
            for (int j = 0; j < crossword[0].length; j++){
                //System.out.println("i:" + i);
                //System.out.println("j:" + j);
                System.out.println(crossword[i][j] + " ");
            }
        }
        return crossword;
    }


}
