package pendu;

import pendu.engine.EngineGameFactory;
import pendu.engine.GameEngine;
import utils.enums.EnumDifficulty;
import utils.wordmanager.WordManager;

/**
 * Main classe of the project.
 * This is how the game works.
 */
public class Pendu {

    /**
     * Pendu instance singleton.
     */
    public static Pendu instance = new Pendu();

    /**
     * Engine to run programm
     */
    private GameEngine gameEngine;

    /**
     * Word to find.
     */
    private String wordTofind;

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
     *
     * @return boolean
     */
    public boolean startGame() {
        // Game running
        wordIsFind = gameEngine.run();
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
        gameEngine = EngineGameFactory.getInstance().getGameEngine(difficulty, wordTofind);
    }

    /**
     * Get the word to find.
     *
     * @return String
     */
    public String getWordTofind() {
        return wordTofind;
    }

    /**
     * Returns true if the word is find.
     *
     * @return boolean
     */
    public boolean isWordIsFind() {
        return wordIsFind;
    }

    /**
     * Return game engine
     *
     * @return game engine used
     */
    public GameEngine getGameEngine() {
        return gameEngine;
    }
}
