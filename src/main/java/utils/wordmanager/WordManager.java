package utils.wordmanager;

import utils.enums.EnumDifficulty;

import java.util.List;

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
    String getRandomWordForDifficulty(EnumDifficulty difficulty);

    /**
     * Get list for word difficulty 1
     *
     * @return corresponding list
     */
    List<String> getWordArrayLevel01();

    /**
     * Get list for word difficulty 2
     *
     * @return corresponding list
     */
    List<String> getWordArrayLevel02();
}

