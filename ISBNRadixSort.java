import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ISBNRadixSort {

    // Method to perform Radix Sort on a list of 13-digit ISBNs
    public static void radixSortISBN13(List<String> isbnList) {
        // Maximum number of digits for ISBN-13 is always 13
        int maxLength = 13;

        // Pad ISBNs to ensure they are all 13 digits long
        for (int i = 0; i < isbnList.size(); i++) {
            isbnList.set(i, String.format("%013d", Long.parseLong(isbnList.get(i))));
        }

        // Perform counting sort for each digit starting from the least significant digit
        for (int pos = maxLength - 1; pos >= 0; pos--) {
            countingSortByDigit(isbnList, pos);
        }
    }

    // Method to perform Radix Sort on a list of 10-digit ISBNs
    public static void radixSortISBN10(List<String> isbnList) {
        // Maximum number of digits for ISBN-10 is always 10
        int maxLength = 10;

        // Pad ISBNs to ensure they are all 10 digits long
        for (int i = 0; i < isbnList.size(); i++) {
            isbnList.set(i, String.format("%010d", Long.parseLong(isbnList.get(i))));
        }

        // Perform counting sort for each digit starting from the least significant digit
        for (int pos = maxLength - 1; pos >= 0; pos--) {
            countingSortByDigit(isbnList, pos);
        }
    }

    // Counting sort based on the digit at a specific position
    private static void countingSortByDigit(List<String> isbnList, int pos) {
       // Set up data
        int n = isbnList.size();
        List<String> output = new ArrayList<>(Collections.nCopies(n, "")); // Output list
        int[] count = new int[10]; // To store count of digits 0-9

        // Step 1: Count occurrences of each digit at position `pos`


        // Step 2: Update count array to store cumulative counts


        // Step 3: Build the output array in stable order


        // Step 4: Copy the sorted ISBNs back into the original list

    }

    // Helper method to get the digit at a specific position in the ISBN string
    private static int getDigitAtPos(String isbn, int pos) {
        return isbn.charAt(pos) - '0';
    }
}
