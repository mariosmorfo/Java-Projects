package gr.aueb.cf;

import java.util.Scanner;

public class Project5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean[][] seats = new boolean[30][12];
        while (true) {
            System.out.println("Επιλέξτε ενέργεια:");
            System.out.println("1. Κράτηση θέσης");
            System.out.println("2. Ακύρωση κράτησης");
            System.out.println("3. Έξοδος");
            int choice = in.nextInt();

            if (choice == 3) {
                System.out.println("Έξοδος απο το πρόγραμμα");
                break;
            }

            System.out.print("Εισάγετε τη στήλη (A-L): ");
            char column = in.next().charAt(0);
            System.out.print("Εισάγετε τη σειρά (1-30): ");
            int row = in.nextInt();

            if (choice == 1) {
                bookSeat(seats, column, row);
            } else if (choice == 2) {
                cancelSeat(seats, column, row);
            } else {
                System.out.println("Μη έγκυρη επιλογή. Προσπαθήστε ξανά.");
            }
        }
    }


    public static void bookSeat(boolean[][] seats, char column, int row) {

        int columnIndex = column - 'A';

        if (columnIndex < 0 || columnIndex > 12 || row < 1 || row > 30) {
            System.out.println("Λάθος είσοδος. Εισάγετε μια έγκυρη σειρά (1-30) και στήλη (A-L)");
            return;
        }
        if (!seats[row - 1][columnIndex]) {
            seats[row - 1][columnIndex] = true;
            System.out.println("Η κράτηση έγινε επιτυχώς για την θέση: " + row + "." + column);

        } else {
            System.out.println("Η κράτηση για την θέση: " + column + row + " είναι ήδη κλεισμένη");
        }


    }

    public static void cancelSeat(boolean[][] seats, char column, int row) {

        int columnIndex = column - 'A';

        if (columnIndex < 0 || columnIndex > 12 || row < 1 || row > 30) {
            System.out.println("Λάθος είσοδος. Εισάγετε μια έγκυρη σειρά (1-30) και μια στήλη (A-L)");
            return;
        }
        if (seats[row - 1][columnIndex]) {
            seats[row - 1][columnIndex] = false;
            System.out.println("Η κράτηση για την θέση: " + row + "." + column + " ακυρώθηκε επιτυχώς");
        } else {
            System.out.println("Η θέση: " + row + column + " δεν είναι κρατημένη οπότε δεν μπορεί να πραγματοποιηθεί ακύρωση");
        }
    }
}