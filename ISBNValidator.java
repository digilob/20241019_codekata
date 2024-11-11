import java.util.ArrayList;
import java.util.List;

public class ISBNValidator {

    // ISBN-10 Validation
    public static boolean isValidISBN10(String isbn) {
        return false;
    }

    // ISBN-13 Validation
    public static boolean isValidISBN13(String isbn) {
        return false;
    }

    // Method to validate a strip - dashes from ISBN
    public static String stripDashes(String isbn) {
        return isbn.replaceAll("-", "");
    }

    // Method to validate a list of ISBNs
    public static List<Boolean> validateISBNs(List<String> isbnList) {
        List<Boolean> results = new ArrayList<>();
        return results;
    }
}