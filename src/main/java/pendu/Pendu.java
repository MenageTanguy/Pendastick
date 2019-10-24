package pendu;

import utils.DrawManager;
import utils.KeyboardManager;
import utils.enums.EnumDifficulty;
import utils.wordmanager.WordManager;

import java.util.Locale;

/**
 * Main classe of the project.
 * This is how the game works.
 */
public class Pendu {

    /**
     * Character used for empty letter space.
     */
    private static final String CHARACTER_EMPTY_LETTER = "=";
    /**
     * Pendu instance singleton.
     */
    public static Pendu instance = new Pendu();
    /**
     * Word to find.
     */
    private String wordTofind;

    /**
     * Current word display.
     */
    private String currentWordState;

    /**
     * Current nb of try.
     */
    private int nbTry;

    /**
     * Current nb of fails.
     */
    private int nbFail;

    /**
     * If word is find = true.
     */
    private boolean wordIsFind;

    /**
     * Private constructor.
     */
    private Pendu() {
    }

    /**
     * Main game method.
     * @return boolean
     */
    public boolean startGame() {
        // Game running
        while (nbFail < 10 && !wordIsFind) {
            newUserLetter();
        }
        // word fine
        if (wordIsFind) {
            System.out.println("Congratz ! You win");
        } else {
            displayInfo();
            System.out.println("Harghh... you loose...");
        }
        return wordIsFind;
    }

    /**
     * init variables and manage each stage.
     *
     * @param difficulty  difficulty choosen by user
     * @param wordManager how words are manage
     */
    public void initGameValues(EnumDifficulty difficulty, WordManager wordManager) {
        wordTofind = wordManager.getRandomWordForDifficulty(difficulty);
        wordIsFind = false;
        nbFail = 0;
        nbTry = 0;
        generateCurrentWordState();
    }

    /**
     * New stage, user enter a new letter.
     */
    private void newUserLetter() {
        nbTry++;
        displayInfo();
        checkLetter(KeyboardManager.instance.readCharacter("Try a letter please : ").toUpperCase(Locale.getDefault()));
    }

    /**
     * This method check if a letter is present in the word and update the current word state if success.
     *
     * @param readCharacter character input by user
     */
    public void checkLetter(String readCharacter) {
        // IF letter is in the word
        if (wordTofind.contains(readCharacter)) {
            for (int i = -1; (i = wordTofind.indexOf(readCharacter, i + 1)) != -1; i++) {
                currentWordState = currentWordState.substring(0, i) + readCharacter + currentWordState.substring(i + 1);
            }
            // if word not contains '=' anymore, user won
            wordIsFind = !currentWordState.contains(CHARACTER_EMPTY_LETTER);
        } else {
            nbFail++;
        }

    }

    /**
     * Display game advancement info (only text here).
     */
    public void displayInfo() {
        System.out.println("\nWord to fine : " + currentWordState);
        System.out.println("Try number : " + nbTry + ", fails : " + nbFail);
        System.out.println(DrawManager.instance.getDrawForThisLooseNumber(nbFail));
    }

    /**
     * Init word to fine;
     */
    private void generateCurrentWordState() {
        currentWordState = "";
        for (int i = 0; i < wordTofind.length(); i++) {
            currentWordState += CHARACTER_EMPTY_LETTER;
        }
    }

    /**
     * Get the word to find.
     * @return String
     */
    public String getWordTofind() {
        return wordTofind;
    }

    /**
     * Get the current state of the word.
     * @return String
     */
    public String getCurrentWordState() {
        return currentWordState;
    }

    /**
     * Returns true if the word is find.
     * @return boolean
     */
    public boolean isWordIsFind() {
        return wordIsFind;
    }
}
