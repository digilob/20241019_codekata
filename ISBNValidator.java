import java.util.ArrayList;
import java.util.List;

public class ISBNValidator {

    // ISBN-10 Validation
    public static boolean isValidISBN10(String isbn) {
        if (isbn == null || isbn.length() != 10) {
            return false;
        }
        // remove dashes
        stripDashes(isbn);
        // check for non-numeric characters in the ISBN 
        if (!isbn.matches("\\d{9}[\\dX]")) {
            return false;
        }

        try {
            int sum = 0;
            for (int i = 0; i < 9; i++) {
                if (!Character.isDigit(isbn.charAt(i))) {
                    return false;
                }
                sum += (isbn.charAt(i) - '0') * (i + 1);
            }
            char lastChar = isbn.charAt(9);
            if (Character.isDigit(lastChar)) {
                sum += (lastChar - '0') * 10;
            } else {
                return false;
            }
            return sum % 11 == 0;
        } catch (Exception e) {
            return false;
        }
    }

    // ISBN-13 Validation
    public static boolean isValidISBN13(String isbn) {
        if (isbn == null || isbn.length() != 13) {
            return false;
        }
        // remove dashes
        stripDashes(isbn);
        // check for non-numeric characters in the ISBN 
        if (!isbn.matches("\\d{9}[\\dX]")) {
            return false;
        }

        try {
            int sum = 0;
            for (int i = 0; i < 12; i++) {
                if (!Character.isDigit(isbn.charAt(i))) {
                    return false;
                }
                int digit = isbn.charAt(i) - '0';
                sum += (i % 2 == 0) ? digit : 3 * digit;
            }
            int lastDigit = isbn.charAt(12) - '0';
            return (sum + lastDigit) % 10 == 0;
        } catch (Exception e) {
            return false;
        }
    }

    // Method to validate a strip - dashes from ISBN
    public static String stripDashes(String isbn) {
        return isbn.replaceAll("-", "");
    }

    // Method to validate a list of ISBNs
    public static List<Boolean> validateISBNs(List<String> isbnList) {
        List<Boolean> results = new ArrayList<>();
        for (String isbn : isbnList) {
            if (isbn.length() == 10) {
                results.add(isValidISBN10(isbn));
            } else if (isbn.length() == 13) {
                results.add(isValidISBN13(isbn));
            } else {
                results.add(false);
            }
        }
        return results;
    }
}