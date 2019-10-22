package utils;

import java.text.Collator;
import java.util.Scanner;

/**
 * Tools to read and check values
 */
public class KeyboardManager {

    /**
     * instance for keyboard management
     */
    public static KeyboardManager instance = new KeyboardManager();

    private static final String ERROR_MESSAGE = "Invalid input, please try again";

    private final Scanner scanner;

    private KeyboardManager() {
        scanner = new Scanner(System.in);
    }

    /**
     * Read and check number
     *
     * @param message message to display
     * @return number read
     */
    public int readNumber(String message) {
        int value;
        boolean error = false;
        while (true) {
            if (error) {
                System.out.println(ERROR_MESSAGE);
            }
            System.out.println(message);
            value = scanner.nextInt();
            if ((Integer) value instanceof Integer) {
                return value;
            }
            error = true;
        }
    }

    /**
     * Read and check String
     *
     * @param message message to display
     * @return string read
     */
    public String readString(String message) {
        String value;
        boolean error = false;
        while (true) {
            if (error) {
                System.out.println(ERROR_MESSAGE);
            }
            System.out.println(message);
            value = scanner.next();
            if (value instanceof String) {
                return value;
            }
            error = true;
        }
    }

    /**
     * Read and check St
     *
     * @param message message to display
     * @return string read
     */
    public String readCharacter(String message) {
        return readString(message).substring(0,1);
    }

    public boolean isSame(String first, String second) {
        Collator insenstiveStringComparator = Collator.getInstance();
        insenstiveStringComparator.setStrength(Collator.PRIMARY);
        return insenstiveStringComparator.compare(first.toLowerCase(), second.toLowerCase()) == 0;
    }

    public int readNumber(String message, int min, int max) {
        int value;
        boolean error = false;
        while (true) {
            if (error) {
                System.out.println(ERROR_MESSAGE);
            }
            System.out.println(message);
            value = scanner.nextInt();
            if (value >= min && value <= max) {
                return value;
            }
            error = true;
        }
    }
}
