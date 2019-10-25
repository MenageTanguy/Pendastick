package pendu.engine;

/**
 * Interface for Game Engine.
 */
public interface GameEngine {

    /**
     * MAin method to run engine.
     *
     * @return true if success to find word
     */
    boolean run();

    /**
     * Display game advancement info (only text here).
     */
    void displayInfo();

    /**
     * This method check if a letter is present in the word and update the current word state if success.
     *
     * @param readCharacter character input by user
     */
    void checkLetter(String readCharacter);

    /**
     * Get current state of word.
     *
     * @return current State of Word
     */
    String getCurrentWordState();


    /**
     * know if word is find.
     *
     * @return true if find;
     */
    boolean isWordIsFind();

}
