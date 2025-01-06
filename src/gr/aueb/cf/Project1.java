package gr.aueb.cf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Project1 {
    public static void main(String[] args) {
        final int NUMBER_SIZE = 6;
        int[] inputNumbers = new int[49];
        int[] result = new int[NUMBER_SIZE];
        int pivot = 0;
        int startLimit;

        try (Scanner in = new Scanner(new File("D:/ΜΑΡΙΟΣ/project1read.txt"));
             PrintStream ps = new PrintStream("D:/ΜΑΡΙΟΣ/project1write.txt", StandardCharsets.UTF_8)) {

            in.useDelimiter(",\\s*");

            while (in.hasNextInt()) {
                int num = in.nextInt();
                if (num == -1 || pivot >= 49) break;
                inputNumbers[pivot++] = num;
            }

            ps.println("Αρχικοί αριθμοί: ");
            for (int i = 0; i < pivot; i++) {
                ps.print(inputNumbers[i] + " ");
            }
            ps.println();
            ps.println("Έγκυροι συνδυασμοί: ");

            int[] numbers = Arrays.copyOfRange(inputNumbers, 0, pivot);
            Arrays.sort(numbers);

            startLimit = pivot - NUMBER_SIZE;

            for (int i = 0; i <= startLimit; i++) {
                for (int j = i + 1; j <= startLimit + 1; j++) {
                    for (int k = j + 1; k <= startLimit + 2; k++) {
                        for (int l = k + 1; l <= startLimit + 3; l++) {
                            for (int m = l + 1; m <= startLimit + 4; m++) {
                                for (int n = m + 1; n <= startLimit + 5; n++) {
                                    result[0] = numbers[i];
                                    result[1] = numbers[j];
                                    result[2] = numbers[k];
                                    result[3] = numbers[l];
                                    result[4] = numbers[m];
                                    result[5] = numbers[n];

                                    if (isEven(result) && isOdd(result) && isConsecutive(result) &&
                                            isSameEnding(result) && isTen(result)) {
                                        ps.printf("%d %d %d %d %d %d\n", result[0], result[1], result[2], result[3], result[4], result[5]);
                                        System.out.printf("%d %d %d %d %d %d\n", result[0], result[1], result[2], result[3], result[4], result[5]);
                                    }
                                }
                            }
                        }
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("Το αρχείο δεν βρέθηκε." + e.getMessage());
        } catch (Exception e) {
            System.err.println("Σφάλμα κατά την ανάγνωση ή εγγραφή του αρχείου. " + e.getMessage());
        }
    }

    public static boolean isEven(int[] arr) {
        long even = 0;
        for (int el : arr) {
            if (el % 2 == 0) {
                even++;
            }
        }
        return even <= 4;
    }

    public static boolean isOdd(int[] arr) {
        long odd = 0;
        for (int el : arr) {
            if (el % 2 != 0) {
                odd++;
            }
        }
        return odd <= 4;
    }

    public static boolean isConsecutive(int[] arr) {
        int cons = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if ((arr[i] == arr[i + 1] - 1)) {
                cons++;
            }
        }
        return cons <= 2;
    }

    public static boolean isSameEnding(int[] arr) {
        int[] endings = new int[10];
        for (int el : arr) {
            endings[el % 10]++;
        }
        for (int count : endings) {
            if (count > 3) {
                return false;
            }
        }
        return true;
    }

    public static boolean isTen(int[] arr) {
        int[]ten = new int[5];
        for (int el : arr) {
            ten[el / 10]++;
            for(int count : ten) {
                if(count > 3) {
                    return false;
                }
            }

        }
        return true;


    }
    }

