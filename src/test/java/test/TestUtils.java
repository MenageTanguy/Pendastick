package test;

import org.junit.Assert;
import utils.KeyboardManager;
import utils.enums.EnumDifficulty;
import utils.wordmanager.WordManager;

import java.io.ByteArrayInputStream;

abstract class TestUtils {

    /**
     * PATH to a test file
     */
    static final String PATH_TO_FILE_TEST = "src/test/java/test/test.txt";

    /**
     * Check Word difficulty using params
     *
     * @param wordManager    word manager to test
     * @param enumDifficulty difficulty tocheck
     */
    void checkWordDifficulty(WordManager wordManager, EnumDifficulty enumDifficulty) {
        checkSizeWordTest(wordManager.getRandomWordForDifficulty(enumDifficulty), enumDifficulty.getMinSize(), enumDifficulty.getMaxSize());
        checkSizeWordTest(wordManager.getRandomWordForDifficulty(enumDifficulty), enumDifficulty.getMinSize(), enumDifficulty.getMaxSize());
        checkSizeWordTest(wordManager.getRandomWordForDifficulty(enumDifficulty), enumDifficulty.getMinSize(), enumDifficulty.getMaxSize());
        checkSizeWordTest(wordManager.getRandomWordForDifficulty(enumDifficulty), enumDifficulty.getMinSize(), enumDifficulty.getMaxSize());
        checkSizeWordTest(wordManager.getRandomWordForDifficulty(enumDifficulty), enumDifficulty.getMinSize(), enumDifficulty.getMaxSize());
    }

    /**
     * Check if random word selector get words existing into
     *
     * @param wordManager wordManager to test
     */
    void checkWordIntoManager(WordManager wordManager) {
        // Difficulty 01
        System.out.println("testPenduRandomWordInternal, check if word is random word is contain in the good list");
        System.out.println("Test difficulty 1 list..");
        Assert.assertTrue("This word is not contain in the list !", wordManager.getWordArrayLevel01().contains(wordManager.getRandomWordForDifficulty(EnumDifficulty.EASY)));
        Assert.assertTrue("This word is not contain in the list !", wordManager.getWordArrayLevel01().contains(wordManager.getRandomWordForDifficulty(EnumDifficulty.EASY)));
        Assert.assertTrue("This word is not contain in the list !", wordManager.getWordArrayLevel01().contains(wordManager.getRandomWordForDifficulty(EnumDifficulty.EASY)));
        System.out.println(".. OK");
        System.out.println("Test difficulty 2 list..");
        // Difficulty 02
        Assert.assertTrue("This word is not contain in the list !", wordManager.getWordArrayLevel02().contains(wordManager.getRandomWordForDifficulty(EnumDifficulty.MEDIUM)));
        Assert.assertTrue("This word is not contain in the list !", wordManager.getWordArrayLevel02().contains(wordManager.getRandomWordForDifficulty(EnumDifficulty.MEDIUM)));
        Assert.assertTrue("This word is not contain in the list !", wordManager.getWordArrayLevel02().contains(wordManager.getRandomWordForDifficulty(EnumDifficulty.MEDIUM)));
        System.out.println(".. OK");
    }

    /**
     * Check if a word have expected size
     *
     * @param randomWordForDifficulty word to test
     * @param minLength               min Size
     * @param maxLenght               max Size
     */
    void checkSizeWordTest(String randomWordForDifficulty, int minLength, int maxLenght) {
        boolean isGoodSize = randomWordForDifficulty.length() >= minLength && randomWordForDifficulty.length() <= maxLenght;
        System.out.println("Word : " + randomWordForDifficulty + "\nSize = " + randomWordForDifficulty.length() + "\n");
        Assert.assertTrue("Word " + randomWordForDifficulty + " have not expected size ! ", isGoodSize);
    }
}
