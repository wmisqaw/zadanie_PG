package com.mygdx.game.desktop;

import java.util.Scanner;

public class CrosswordCreator {

    public static char crossword[][];

    public static void main(String[] args){
        sizeChoosing();
        for (int i = 0; i < crossword.length; i++){
            for (int j = 0; j < crossword[0].length; j++){
                //System.out.println("i:" + i);
                //System.out.println("j:" + j);
                System.out.println(crossword[i][j] + " ");
            }
        }
        //char[][] crossword_grid = sizeChoosing();
    }

    public static char[][] sizeChoosing(){
        Scanner input = new Scanner(System.in);
        System.out.println("Choose size of crossword in range 3 to 15 ! ");
        System.out.println("Rows : ");
        int rows = Integer.parseInt(input.next());
        System.out.println("Columns : ");
        int columns = Integer.parseInt(input.next());
        crossword = new char[rows][columns];
        return crossword;
    }


}
