import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ISBNRadixSort {

    // Method to perform Radix Sort on a list of 13-digit ISBNs
    public static void radixSortISBN13(List<String> isbnList) {
        int maxLength = 13;
        for (int i = 0; i < isbnList.size(); i++) {
            isbnList.set(i, String.format("%013d", Long.parseLong(isbnList.get(i))));
        }
        for (int pos = maxLength - 1; pos >= 0; pos--) {
            countingSortByDigit(isbnList, pos);
        }
    }

    // Method to perform Radix Sort on a list of 10-digit ISBNs
    public static void radixSortISBN10(List<String> isbnList) {
        int maxLength = 10;
        for (int i = 0; i < isbnList.size(); i++) {
            isbnList.set(i, String.format("%010d", Long.parseLong(isbnList.get(i))));
        }
        for (int pos = maxLength - 1; pos >= 0; pos--) {
            countingSortByDigit(isbnList, pos);
        }
    }

    // Counting sort based on the digit at a specific position
    private static void countingSortByDigit(List<String> isbnList, int pos) {
        int n = isbnList.size();
        List<String> output = new ArrayList<>(Collections.nCopies(n, "")); // Output list
        int[] count = new int[10]; // To store count of digits 0-9

        // Step 1: Count occurrences of each digit at position `pos`
        for (String isbn : isbnList) {
            int digit = getDigitAtPos(isbn, pos);
            count[digit]++;
        }

        // Step 2: Update count array to store cumulative counts
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Step 3: Build the output array in stable order
        for (int i = n - 1; i >= 0; i--) {
            String isbn = isbnList.get(i);
            int digit = getDigitAtPos(isbn, pos);
            output.set(count[digit] - 1, isbn);
            count[digit]--;
        }

        // Step 4: Copy the sorted ISBNs back into the original list
        for (int i = 0; i < n; i++) {
            isbnList.set(i, output.get(i));
        }
    }

    // Helper method to get the digit at a specific position in the ISBN string
    private static int getDigitAtPos(String isbn, int pos) {
        return isbn.charAt(pos) - '0';
    }
}
