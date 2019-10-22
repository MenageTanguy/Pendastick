package pendu;

import utils.WordManager;

/**
 * Main classe of the project
 * This is how work the game
 */
public class Pendu {

    /**
     * Pendu INSTANCE singleton
     */
    public static Pendu INSTANCE = new Pendu();

    private Pendu() {
    }

    public void startGame(int difficulty) {
        String wordTofine = WordManager.INSTANCE.getRandomWordForDifficulty(difficulty);
    }
}
