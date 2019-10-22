package pendu;

import utils.DrawManager;
import utils.KeyboardManager;
import utils.WordManager;

import java.awt.event.KeyEvent;

/**
 * Main classe of the project
 * This is how work the game
 */
public class Pendu {

    /**
     * Pendu INSTANCE singleton
     */
    public static Pendu INSTANCE = new Pendu();

    private static final String CHARACTER_EMPTY_LETTER = "=";

    private String wordTofine;

    private String currentWordState;

    private int nbTry, nbFail;

    private boolean isWordFine;

    private Pendu() {
    }

    /**
     * Main game method
     * init variables and manage each stage
     *
     * @param difficulty difficulty choosen by user
     */
    public void startGame(int difficulty) {
        wordTofine = WordManager.INSTANCE.getRandomWordForDifficulty(difficulty).toUpperCase();
        isWordFine = false;
        nbFail = 0;
        nbTry = 0;
        generateCurrentWordState();
        // Game running
        while (nbFail < 10 && !isWordFine) {
            newUserLetter();
        }
        // word fine
        if (isWordFine)
            System.out.println("Congratz ! You win");
        else {
            displayInfo();
            System.out.println("Harghh... you loose...");
        }
    }

    /**
     * New stage, user enter a new letter
     */
    private void newUserLetter() {
        nbTry++;
        displayInfo();
        checkLetter(KeyboardManager.INSTANCE.readCharacter("Try a letter please : ").toUpperCase());
    }

    /**
     * This method check if a letter is present in the word and update the current word state if success
     *
     * @param readCharacter character input by user
     */
    private void checkLetter(String readCharacter) {
        // IF letter is in the word
        if (wordTofine.contains(readCharacter)) {
            for (int i = -1; (i = wordTofine.indexOf(readCharacter, i + 1)) != -1; i++) {
                currentWordState = currentWordState.substring(0, i) + readCharacter + currentWordState.substring(i + 1);
            }
            // if word not contains '=' anymore, user won
            isWordFine = !currentWordState.contains(CHARACTER_EMPTY_LETTER);
        } else {
            nbFail++;
        }

    }

    /*
     * Display game advancement info (only text here)
     */
    private void displayInfo() {
        System.out.println("\nWord to fine : " + currentWordState);
        System.out.println("Try number : " + nbTry + ", fails : " + nbFail);
        System.out.println(DrawManager.INSTANCE.getDrawForThisLooseNumber(nbFail));
    }

    /**
     * Init word to fine;
     */
    private void generateCurrentWordState() {
        currentWordState = "";
        for (int i = 0; i < wordTofine.length(); i++) {
            currentWordState += CHARACTER_EMPTY_LETTER;
        }
    }
}
