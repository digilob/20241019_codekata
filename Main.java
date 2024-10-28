import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Example test case
        List<String> isbnList = Arrays.asList("0306406152", "9780306406157", "123456789X", "9781234567890");
        System.out.println(ISBNValidator.validateISBNs(isbnList)); // Outputs: [true, true, true, false]

        // Example test case for Radix Sort
        List<String> isbnValidatedList = new ArrayList<>(Arrays.asList("9780306406157", "9781234567890", "9781230000000", "9780306401234", "9789999999999"));

        // add isbnList to isbnValidatedList if ISBNValidator.validateISBNs(isbnList) returns true
        isbnList.forEach(isbn -> {
            if (ISBNValidator.validateISBNs(Arrays.asList(isbn)).get(0)) {
                isbnValidatedList.add(isbn);
            }
        });

        // Print unsorted ISBN list
        System.out.println("Before Radix Sort: " + isbnValidatedList);

        // Perform Radix Sort on the list of ISBNs
        ISBNRadixSort.radixSortISBN13(isbnValidatedList);

        // Print sorted ISBN list
        System.out.println("After Radix Sort: " + isbnValidatedList);
    }
}