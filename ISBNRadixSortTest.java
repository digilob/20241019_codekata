import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ISBNRadixSortTest {

    @Test
    public void testRadixSortISBN13() {
        List<String> isbnList = Arrays.asList("9780306406157", "9780306406152", "9780306406153");
        List<String> expected = Arrays.asList("9780306406152", "9780306406153", "9780306406157");
        ISBNRadixSort.radixSortISBN13(isbnList);
        assertEquals(expected, isbnList);
    }

    @Test
    public void testRadixSortISBN10() {
        List<String> isbnList = Arrays.asList("0306406152", "0306406157", "0306406153");
        List<String> expected = Arrays.asList("0306406152", "0306406153", "0306406157");
        ISBNRadixSort.radixSortISBN10(isbnList);
        assertEquals(expected, isbnList);
    }

    @Test
    public void testRadixSortISBN13WithLeadingZeros() {
        List<String> isbnList = Arrays.asList("0000000000001", "0000000000003", "0000000000002");
        List<String> expected = Arrays.asList("0000000000001", "0000000000002", "0000000000003");
        ISBNRadixSort.radixSortISBN13(isbnList);
        assertEquals(expected, isbnList);
    }

    @Test
    public void testRadixSortISBN10WithLeadingZeros() {
        List<String> isbnList = Arrays.asList("0000000001", "0000000003", "0000000002");
        List<String> expected = Arrays.asList("0000000001", "0000000002", "0000000003");
        ISBNRadixSort.radixSortISBN10(isbnList);
        ISBNRadixSort.radixSortISBN10(isbnList);
        assertEquals(expected, isbnList);
    }
}