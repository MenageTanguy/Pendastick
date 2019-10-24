package pendu.engine;

import utils.enums.EnumDifficulty;

/**
 * Word manager factory.
 */
public class EngineGameFactory {

    /**
     * factory instance.
     */
    private static EngineGameFactory instance = new EngineGameFactory();

    /**
     * Singleton.
     *
     * @return word manager factory
     */
    public static EngineGameFactory getInstance() {
        return instance;
    }

    /**
     * Get good word manager for given paramaters.
     *
     * @param difficulty difficulty choosen
     * @param wordTofind word to find
     * @return the expected wordManager
     */
    public GameEngine getGameEngine(EnumDifficulty difficulty, String wordTofind) {
        GameEngine gameEngine;
        if (EnumDifficulty.HARD.equals(difficulty)) {
            gameEngine = new HardGameEngine(wordTofind);
        } else {
            gameEngine = new SimpleGameEngine(wordTofind);
        }
        return gameEngine;
    }
}
