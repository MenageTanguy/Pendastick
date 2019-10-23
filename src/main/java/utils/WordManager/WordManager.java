package utils.WordManager;

import java.util.ArrayList;

/**
 * Use this word manager for words
 */
public interface WordManager {

    /**
     * Get a random word corresponding to the selected difficulty
     *
     * @param difficulty difficulty choosen
     * @return a random word for this difficulty
     */
    String getRandomWordForDifficulty(int difficulty);

    /**
     * Get list for word difficulty 1
     *
     * @return corresponding list
     */
    ArrayList<String> getWordArrayLevel01();

    /**
     * Get list for word difficulty 2
     *
     * @return corresponding list
     */
    ArrayList<String> getWordArrayLevel02();
}

