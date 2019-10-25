package pendu.engine;

import utils.KeyboardUtils;

import java.util.Locale;

/**
 * Abstract class to manage game Engine.
 */
public abstract class AbstractGameEngine implements GameEngine {

    /**
     * Character used for empty letter space.
     */
    protected static final String CHARACTER_EMPTY_LETTER = "=";

    /**
     * Word to find.
     */
    protected transient String wordTofind;

    /**
     * Current word display.
     */
    protected transient String currentWordState;

    /**
     * Current nb of try.
     */
    protected transient int nbTry;

    /**
     * Current nb of fails.
     */
    protected transient int nbFail;

    /**
     * If word is find = true.
     */
    protected transient boolean wordIsFind;

    /**
     * nb Fail authorized before lose.
     */
    protected transient int nbFailAuthorized;

    AbstractGameEngine(String wordTofind) {
        this.wordTofind = wordTofind;
        generateCurrentWordState();
        init();
    }

    @Override
    public boolean run() {
        while (nbFail < nbFailAuthorized && !wordIsFind) {
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
     * New stage, user enter a new letter.
     */
    private void newUserLetter() {
        nbTry++;
        displayInfo();
        checkLetter(KeyboardUtils.readCharacter("Try a letter please : ").toUpperCase(Locale.getDefault()));
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
     * Getter current word state.
     *
     * @return current word state.
     */
    public String getCurrentWordState() {
        return currentWordState;
    }

    /**
     * Getter is word fine.
     *
     * @return isWordfine
     */
    public boolean isWordIsFind() {
        return wordIsFind;
    }

    /**
     * Abstract method to init engine.
     */
    protected abstract void init();

    /**
     * get wordTofind.
     *
     * @return wordTofind
     */
    public String getWordTofind() {
        return wordTofind;
    }

    /**
     * get getNbTry.
     *
     * @return nbTry
     */
    public int getNbTry() {
        return nbTry;
    }

    /**
     * get getNbFail.
     *
     * @return nbFail
     */
    public int getNbFail() {
        return nbFail;
    }

    /**
     * get getNbFailAuthorized.
     *
     * @return nbFailAuthorized
     */
    public int getNbFailAuthorized() {
        return nbFailAuthorized;
    }
}