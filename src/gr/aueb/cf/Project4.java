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

            int[] move = movePlayer(currentPlayer);
            board[move[0]][move[1]] = currentPlayer;


            if(checkWinner(currentPlayer)) {
                displayBoard();
                System.out.println("Player " + (currentPlayer == 1 ? "X" : "0") + " wins!");
                break;
            }

            if(isBoardFull()) {
                displayBoard();
                System.out.println(" It's a tie");
                break;
            }
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
        return !(row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != 0);
    }

    public static int[] movePlayer(int currentPlayer) {
        int row, col;

        while (true) {

            System.out.println("Enter row 0-2): ");
            row = in.nextInt();

            System.out.println("Enter col 0-2): ");
            col = in.nextInt();

            if (isMoveValid(row, col)) {
                board[row][col] = currentPlayer;
                return new int[]{row, col};
            } else {
                System.out.println("Invalid move. Please try again");
            }
        }
    }

    public static boolean checkWinner(int currentPlayer){
        for(int i = 0; i < 3; i++) {
            if(board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
            for(int j = 0; j < 3; j++){
                if(board[0][j] == currentPlayer && board[1][j] == currentPlayer && board[2][j] == currentPlayer){
                    return true;
                }
                if(board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer){
                    return true;
                }
                if(board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isBoardFull(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[j][i] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

}