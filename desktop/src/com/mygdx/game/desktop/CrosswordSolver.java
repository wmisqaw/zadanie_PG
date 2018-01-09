package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.Hello;

import java.util.Arrays;
import java.util.Scanner;

public class CrosswordSolver
{
    private static enum Direction {
        E, NE, N, NW, W, SW, S, SE
    }

    private char[][] grid, crossword;
    private int rows, cols;

    public CrosswordSolver(char[][] g) {

        // Initializes dimensions:
        grid = g;
        rows = g.length;
        cols = g[0].length;

        // Initializes the solved
        // crossword array with default
        // characters:
        int r, c;
        crossword = new char[rows][cols];
        for (r = 0; r < rows; r++)
            for (c = 0; c < cols; c++)
                crossword[r][c] = '-';

        // Prints the initial array:
        System.out.println("Initial:\n");
        print2DArray(grid);
        System.out.println();
    }

    void searchWords(String word) {

        // Sends to discover each word in
        // the letter array:
        System.out.println("Word in search:");

        System.out.printf("%s %s\n", searchWord(word) != 0 ? "/" : "-", word);

        // Prints the solved crossword:
        print2DArray(crossword);
        System.out.println();
    }

    private int searchWord(String word) {

        if (word == null
                || word.isEmpty())
            return 0;

        int found = 0;
        char frstC = word.charAt(0);
        boolean isOneLetter;
        isOneLetter = word.length() == 1;

        // Iterates through cells in the
        // grid trying to match the first
        // letter, and then search around:
        int r, c;
        for (r = 0; r < rows; r++)
            for (c = 0; c < cols; c++)
                if (grid[r][c] == frstC)
                    if (isOneLetter) {
                        crossword[r][c] = frstC;
                        found++;
                    }
                    else
                        found += searchAround(c, r, word);

        return found;
    }

    private int searchAround(int cX, int cY, String word) {

        int wordsFound = 0;
        boolean markOutMode, found;
        char grdCh, wrdCh;
        int i, x, y;

        for (Direction dir : Direction.values()) {

            // Initializes the start of each
            // direction with these values:
            markOutMode = false;
            found = true;

            // While loop run max twice: one
            // for find the word in one
            // direction and, if finds it
            // run it again to store the
            // letters.
            while (markOutMode || found) {
                for (i = markOutMode ? 0 : 1, x = cX, y = cY; i < word.length(); i++) {

                    wrdCh = word.charAt(i);
                    if (markOutMode)
                        crossword[y][x] = wrdCh;

                    // Updates the coordinates of
                    // the next position in the
                    // current direction:
                    switch (dir) {
                        case E: x++; break;
                        case NE: x++; y--; break;
                        case N: y--; break;
                        case NW: x--; y--; break;
                        case W: x--; break;
                        case SW: x--; y++; break;
                        case S: y++; break;
                        case SE: x++; y++; break;
                    }

                    // In mark out mode don't
                    // check for equality again.
                    if (markOutMode) continue;

                    // With the first character
                    // that does not match or an
                    // error for exceeding the
                    // limit indicates that the
                    // word was not found in the
                    // current direction.
                    try {
                        grdCh = grid[y][x];
                        if (wrdCh != grdCh) {
                            found = false;
                            break;
                        }
                    } catch (Exception e) {
                        found = false;
                        break;
                    }
                }

                // To run the while loop again,
                // now in mark out mode:
                if (found) {
                    wordsFound++;
                    found = false;
                    markOutMode = true;
                } else markOutMode = false;
            }
        }

        return wordsFound;
    }

    private static void print2DArray(char[][] arr) {
        for (char[] cA : arr) {
            for (char c : cA)
                System.out.print(c + " ");
            System.out.println();
        }
    }

    public static int levelChosing(){
        Scanner input = new Scanner(System.in);
        System.out.print("Choose crossword 1, 2 or 3 : ");
        int level = Integer.parseInt(input.next());
        return level;
    }

    public static String input_data() {
        Scanner input = new Scanner(System.in);
        System.out.print("input data : ");
        String input_word = input.next();
        String upper = input_word.toUpperCase();

        return upper;
    }


    public static void main(String[] args)
    {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        new LwjglApplication(new Hello(), config);

        int missing_words;
        String search;
        char[][] grid = {};
        char[][] grid1 = {
                "AAKLAP".toCharArray(),
                "DCLIRR".toCharArray(),
                "OIOAAA".toCharArray(),
                "HCSNML".toCharArray(),
                "AAOANE".toCharArray(),
                "NKJUDS".toCharArray(),
                "ACAVOK".toCharArray(),
        };
        char[][] grid2 = {
                "KRAVABODZO".toCharArray(),
                "PAGACDOOEY".toCharArray(),
                "ALUDNAVELN".toCharArray(),
                "RALKUDFNEI".toCharArray(),
                "ACIPOAILNN".toCharArray(),
                "DKCONMUHID".toCharArray(),
                "AAKAOAOKNZ".toCharArray(),
                "JRAKOLEDAA".toCharArray(),
                "KAABRADAAR".toCharArray(),
                "ABABICKAAP".toCharArray()
        };
        char[][] grid3 = {
                "AASPODLZNOSTOHRADAS".toCharArray(),
                "BNLCADAROPAESLLCKOK".toCharArray(),
                "IIARITASMOVPRAVIDLO".toCharArray(),
                "LLLMATKAJMANRVPNIAK".toCharArray(),
                "OIONKKPROGRESOSELRA".toCharArray(),
                "KZMLOAZANAOOSLTSIBN".toCharArray(),
                "OOGESTOOZLMTOARTSRO".toCharArray(),
                "KTAVTULPNARNJMISTOP".toCharArray(),
                "RSRIOKCOTOLOKKGEIZE".toCharArray(),
                "EEACLOAEJKPKAZARNUR".toCharArray(),
                "SMZEVPOKOJYRAVOTAMA".toCharArray()
        };

        String[] grid1_words = {"JAMA", "KACICA","KONAR","KOVAC","LIANA","NAHODA","OSOL",
                "PALKA","PRALES","PRASA"};
        System.out.println(grid1_words.length);

        String[] grid2_words = {"ARAB", "BABICKA","BARAK", "BRADA","BRLOH","CALAMADA","DUKLA",
                "GULICKA","HUMNO","KOLEDA","KOMIN", "KOMODA","KRAVA","LEVANDULA","OBAVA",
                "ODVOZ","OPICA","OZDOBA","PAGAC", "PARADAJKA","PRAZDNINY","ZELENINA"};

        String[] grid3_words = {"AZALAKA", "BRALO","GARAZ", "GESTO","HLAVOLAM","KAJMAN","KOALA",
                "KOLIBA","KOLOTOC","KOMNATA","KONTO", "KOSTOL","KRITIKA","LEVICE","LIMETKA",
                "LISTINA","MESTO","MORAVA","OHRADA", "OKRES","OPERA","PODLZNOST","POKOJ",
                "POKUTA","PLUTVA","PONOZKA","PORADA", "POSTROJ","PRAVDILO","PRIEPAST","PROGRES",
                "ROZUM","SATIRA","SENICA","SKOKAN", "SLALOM","SOJKA","STRIGA","TOVAR",
                "TREST","ZNOJMO","ZILINA"};

        int s = levelChosing();
        switch (s){
            case 1:
                System.out.println("User chosen level 1");
                System.out.println("S casopisom Flak nikdy nie je .... (tajnicka1)");
                System.out.print("Search words: ");
                for (int i = 0; i < grid1_words.length; i++) {
                    System.out.print(grid1_words[i] + ", ");
                }
                grid = grid1;
                break;
            case 2:
                System.out.println("User chosen level 2");
                System.out.println("Niektori ludia ludia su zamilovani do .... (tajnicka2)");
                System.out.print("Search words: ");
                for (int i = 0; i < grid2_words.length; i++) {
                    System.out.print(grid2_words[i] + ", ");
                }
                grid = grid2;
                break;
            case 3:
                System.out.println("User chosen level 3");
                System.out.println("Kandidat na starostu obce rano pred volbami odchadza z domu a hovori manzelke: " +
                        "- Bud pridem domov ako starosta, alebo ako .... (tajnicka3)");
                System.out.print("Search words: ");
                for (int i = 0; i < grid3_words.length; i++) {
                    System.out.print(grid3_words[i] + ", ");
                }
                grid = grid3;
                break;
            default:
                    System.out.println("Wrong input!");
                    break;

        }


        CrosswordSolver cS = new CrosswordSolver(grid);
        //for (int i = 0; i < grid1_words.length; i++){
        switch (s){
            case 1:
                missing_words = grid1_words.length;
                break;
            case 2:
                missing_words = grid2_words.length;
                break;
            case 3:
                missing_words = grid3_words.length;
                break;
            default:
                missing_words = 0;
                System.out.println("Wrong input");
                    break;
        }
        //missing_words = grid1_words.length;
        for (int i = 0; i < missing_words; i++){
            search = input_data();
            if (Arrays.asList(grid1_words).contains(input_data())) {
                missing_words --;
            }
            if (missing_words == 0){
                System.out.println("Crossword SOLVED!");
                break;
            }
            cS.searchWords(search);
        }

        while (Arrays.asList(grid1_words).contains(input_data())){
            missing_words --;
            if (missing_words == 0){
                System.out.println("Crossword SOLVED!");
                break;
            }
        }




    }
}