package gr.aueb.cf;

import java.util.Scanner;

public class Project4 {

    public static Scanner in = new Scanner(System.in);
    public static int[][] board = new int[3][3];

    public static void main(String[] args) {

         initializeBoard();
        int currentPlayer = 1;

        while (true){

            displayBoard();
            System.out.println("Player " + (currentPlayer == 1 ? "X" : "O") + " it's your turn");

            int[] move = movePlayer();
            board[move[0]][move[1]] = currentPlayer;

            currentPlayer = (currentPlayer == 1) ? 2 : 1;
        }



    }

    public static void initializeBoard () {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = 0;
            }
        }
    }

    public static void displayBoard(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    System.out.print("   ");
                } else if (board[i][j] == 1) {
                    System.out.print(" X ");
                } else if (board[i][j] == 2) {
                    System.out.print(" O ");
                }


                if (j < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---+---+---");
            }
        }
    }

    public static boolean isMoveValid(int row, int col){

        if(row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }
        if(board[row][col] != 0) {
            return false;
        }
        return true;
    }

    public static int[] movePlayer() {
        int row, col;

        while (true) {
            System.out.println("Enter your move (row and col 0-2): ");
            row = in.nextInt();
            col = in.nextInt();

            if(isMoveValid(row, col)){
                break;
            }else {
                System.out.println("Invalid move. Please try again");
            }
        }
        return new int[]{col,row};
    }
}