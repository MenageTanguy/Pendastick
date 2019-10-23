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

    /**
     * STATIC error message display if invalid input
     */
    private static final String ERROR_MESSAGE = "Invalid input, please try again";

    /**
     * Scanner used to read console input
     */
    private final Scanner scanner;

    /**
     * Private constructor
     */
    private KeyboardManager() {
        scanner = new Scanner(System.in);
    }


    /**
     * Read and check String
     *
     * @param message message to display
     * @return string read
     */
    private String readString(String message) {
        String value;
        boolean error = false;
        while (true) {
            if (error) {
                System.out.println(ERROR_MESSAGE);
            }
            System.out.println(message);
            value = scanner.nextLine().trim();
            if (!value.isEmpty()) {
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
        String input = readString(message);
        if (input.length() > 1) {
            System.out.println("Only one character expected, please try again");
            return readCharacter(message);
        } else if (isValidLetter(input)) {
            return input;
        } else {
            System.out.println("This input is not letter, try again please");
            return readCharacter(message);
        }
    }

    /**
     * Method to check if a specific string is a valid letter
     *
     * @param name string to check
     * @return true if alphabetic letter
     */
    private boolean isValidLetter(String name) {
        return name.matches("[a-zA-Z]+");
    }

    /**
     * Check if two words are the same (insensitive comparator)
     *
     * @param word1 word 1 to check
     * @param word2 word 2 to check
     * @return true if same
     */
    public boolean isSame(String word1, String word2) {
        Collator insenstiveStringComparator = Collator.getInstance();
        insenstiveStringComparator.setStrength(Collator.PRIMARY);
        return insenstiveStringComparator.compare(word1.toLowerCase(), word2.toLowerCase()) == 0;
    }

    /**
     * Read number with border
     *
     * @param message message to display
     * @param min     min value expected
     * @param max     max value expected
     * @return value if correct
     */
    public int readNumber(String message, int min, int max) {
        int value;
        System.out.println(message);
        String input = scanner.nextLine().trim();
        if (isInteger(input)) {
            value = Integer.valueOf(input);
            if (value >= min && value <= max) {
                return value;
            }
        }
        System.out.println(ERROR_MESSAGE);
        return readNumber(message, min, max);
    }


    /**
     * Method to check if a string is an integer
     *
     * @param input string to check
     * @return true if good
     */
    private boolean isInteger(String input) {
        if (input.isEmpty()) return false;
        for (int i = 0; i < input.length(); i++) {
            if (i == 0 && input.charAt(i) == '-') {
                if (input.length() == 1) return false;
                else continue;
            }
            if (Character.digit(input.charAt(i), 10) < 0) return false;
        }
        return true;
    }

}
