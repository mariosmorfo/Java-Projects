package gr.aueb.cf;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Project3 {
    public static void main(String[] args) {
        int[][] grid = new int[128][2];
        initializeGrid(grid);
        for (int i = 0; i < 128; i++) {
            grid[i][0] = -1;
        }

        try (BufferedReader br = new BufferedReader(new FileReader("D:/project3read.txt"))) {
            int ch;

            while ((ch = br.read()) != -1){
                if(isLatinCharacter(ch)) {
                    addToGrid(grid, ch);
                }
            }

        } catch (IOException e) {
            System.err.println("Το αρχείο δεν βρέθηκε");
        }
        printGrid(grid);
    }

    private static void addToGrid(int[][] grid, int character) {
        for (int i = 0; i < 128; i++) {
            if (grid[i][0] == character) {
                grid[i][1]++;
                return;
            }

            if (grid[i][0] == -1) {
                grid[i][0] = character;
                grid[i][1] = 1;
                return;
            }
        }
    }

    private static void initializeGrid(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            grid[i][0] = -1;
            grid[i][1] = 0;
        }
    }

    private static boolean isLatinCharacter(int ch) {
        if ((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122)) {
            return true;
        }
        return false;
    }
    private static void printGrid(int[][] grid) {
        System.out.println("Character | Frequency");
        System.out.println("---------------------");
        for (int i = 0; i < grid.length; i ++) {
            if(grid[i][0] != -1) {
                System.out.printf("       %c  |  %d    \n", grid[i][0], grid[i][1]);
            }

        }
    }
    }

