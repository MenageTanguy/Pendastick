package utils;

import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.text.Collator;
import java.util.Locale;
import java.util.Scanner;

/**
 * Tools to read and check values.
 */
public final class KeyboardUtils {

    /**
     * STATIC error message display if invalid input.
     */
    private static final String ERROR_MESSAGE = "Invalid input, please try again";

    /**
     * Static character size.
     */
    private static final int CHARACTER_SIZE = 1;


    /**
     * Scanner used to read console input
     */
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Private constructor
     */
    private KeyboardUtils() {
    }

    /**
     * Method to check if string is a valid path
     *
     * @param path string to check
     * @return true if valid path
     */
    private static boolean isValidPath(String path) {
        boolean valid;
        try {
            valid = Files.exists(Paths.get(path));
        } catch (InvalidPathException ex) {
            valid = false;
        }
        return valid;
    }

    /**
     * Read and check String
     *
     * @param message message to display
     * @return string read
     */
    private static String readString(String message) {
        String value;
        while (true) {
            System.out.println(message);
            value = scanner.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println(ERROR_MESSAGE);
        }
    }

    /**
     * Read and check String.
     *
     * @param message message to display
     * @return string read
     */
    public static String readCharacter(String message) {
        String input = readString(message);
        if (input.length() > CHARACTER_SIZE) {
            System.out.println("Only one character expected, please try again");
        } else if (isValidLetter(input)) {
            return input;
        } else {
            System.out.println("This input is not letter, try again please");
        }
        return readCharacter(message);
    }

    /**
     * Method to check if a specific string is a valid letter.
     *
     * @param name string to check
     * @return true if alphabetic letter
     */
    private static boolean isValidLetter(String name) {
        return name.matches("[a-zA-Z]+");
    }

    /**
     * Check if two words are the same (insensitive comparator).
     *
     * @param word1 word 1 to check
     * @param word2 word 2 to check
     * @return true if same
     */
    public static boolean isSame(String word1, String word2) {
        Collator insenstiveComparator = Collator.getInstance();
        insenstiveComparator.setStrength(Collator.PRIMARY);
        return insenstiveComparator.compare(
                word1.toLowerCase(Locale.getDefault()),
                word2.toLowerCase(Locale.getDefault())) == 0;
    }

    /**
     * Read number with border.
     *
     * @param message message to display
     * @param min     min value expected
     * @param max     max value expected
     * @return value if correct
     */
    public static int readNumber(String message, int min, int max) {
        int value;
        System.out.println(message);
        String input = scanner.nextLine().trim();
        if (isInteger(input)) {
            value = Integer.parseInt(input);
            if (value >= min && value <= max) {
                return value;
            }
        }
        System.out.println(ERROR_MESSAGE);
        return readNumber(message, min, max);
    }

    /**
     * Method to check if a string is an integer.
     *
     * @param input string to check
     * @return true if good
     */
    private static boolean isInteger(String input) {
        if (input.isEmpty()) {
            return false;
        }
        for (int i = 0; i < input.length(); i++) {
            if (i == 0 && input.charAt(i) == '-') {
                if (input.length() == CHARACTER_SIZE) {
                    return false;
                } else {
                    continue;
                }
            }
            if (Character.digit(input.charAt(i), 10) < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method to ask user a path and check it.
     *
     * @param message message to display
     * @return valid path
     */
    public static String readPath(String message) {
        String input = readString(message);
        if (!isValidPath(input)) {
            System.out.println("This path doesn't exist, please try another one.");
            return readPath(message);
        }
        return input;
    }
}
