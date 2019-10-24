package test;

import org.junit.Assert;
import org.junit.Test;
import pendu.Pendu;
import utils.enums.EnumDifficulty;
import utils.wordmanager.WordManager;
import utils.wordmanager.WordManagerFactory;

public class TestPendu extends TestUtils {

    /**
     * Test a Game init EASY difficulty
     * Word Manager internal
     */
    @Test
    public void testMainGameDifficulty01Internal() {
        System.out.println("testMainGameDifficulty01 --> check if init game have a good and valid word");
        WordManager wordManager = WordManagerFactory.getInstance().getWordManager(true, "");
        Pendu.instance.initGameValues(EnumDifficulty.EASY, wordManager);

        // Check word to find
        String wordTofine = Pendu.instance.getWordTofind();
        checkSizeWordTest(wordTofine, EnumDifficulty.EASY.getMinSize(), EnumDifficulty.EASY.getMaxSize());

        // Check word display mask is correct ( = same size as wordTOfine + only "=" characters)
        String wordDisplay = Pendu.instance.getCurrentWordState();
        checkSizeWordTest(wordDisplay, EnumDifficulty.EASY.getMinSize(), EnumDifficulty.EASY.getMaxSize());
        Assert.assertEquals(wordTofine.length(), wordDisplay.length());
        Assert.assertEquals(wordDisplay.length(), wordDisplay.length() - (wordDisplay.replace("=", "")).length());
    }

    /**
     * Test a Game init MEDIUM difficulty
     * Word Manager internal
     */
    @Test
    public void testMainGameDifficulty02Internal() {
        System.out.println("testMainGameDifficulty01 --> check if init game have a good and valid word");
        WordManager wordManager = WordManagerFactory.getInstance().getWordManager(true, "");
        Pendu.instance.initGameValues(EnumDifficulty.MEDIUM, wordManager);

        // Check word to find
        String wordTofine = Pendu.instance.getWordTofind();
        checkSizeWordTest(wordTofine, EnumDifficulty.MEDIUM.getMinSize(), EnumDifficulty.MEDIUM.getMaxSize());

        // Check word display mask is correct ( = same size as wordTOfine + only "=" characters)
        String wordDisplay = Pendu.instance.getCurrentWordState();
        checkSizeWordTest(wordDisplay, EnumDifficulty.MEDIUM.getMinSize(), EnumDifficulty.MEDIUM.getMaxSize());
        Assert.assertEquals(wordTofine.length(), wordDisplay.length());
        Assert.assertEquals(wordDisplay.length(), wordDisplay.length() - (wordDisplay.replace("=", "")).length());
    }

    /**
     * Test a Game init EASY difficulty
     * Word Manager external
     */
    @Test
    public void testMainGameDifficulty01External() {
        System.out.println("testMainGameDifficulty01 --> check if init game have a good and valid word");
        WordManager wordManager = WordManagerFactory.getInstance().getWordManager(false, PATH_TO_FILE_TEST);
        Pendu.instance.initGameValues(EnumDifficulty.EASY, wordManager);

        // Check word to find
        String wordTofine = Pendu.instance.getWordTofind();
        checkSizeWordTest(wordTofine, EnumDifficulty.EASY.getMinSize(), EnumDifficulty.EASY.getMaxSize());

        // Check word display mask is correct ( = same size as wordTOfine + only "=" characters)
        String wordDisplay = Pendu.instance.getCurrentWordState();
        checkSizeWordTest(wordDisplay, EnumDifficulty.EASY.getMinSize(), EnumDifficulty.EASY.getMaxSize());
        Assert.assertEquals(wordTofine.length(), wordDisplay.length());
        Assert.assertEquals(wordDisplay.length(), wordDisplay.length() - (wordDisplay.replace("=", "")).length());
    }

    /**
     * Test a Game init MEDIUM difficulty
     * Word Manager external
     */
    @Test
    public void testMainGameDifficulty02External() {
        System.out.println("testMainGameDifficulty01 --> check if init game have a good and valid word");
        WordManager wordManager = WordManagerFactory.getInstance().getWordManager(false, PATH_TO_FILE_TEST);
        Pendu.instance.initGameValues(EnumDifficulty.MEDIUM, wordManager);

        // Check word to find
        String wordTofine = Pendu.instance.getWordTofind();
        checkSizeWordTest(wordTofine, EnumDifficulty.MEDIUM.getMinSize(), EnumDifficulty.MEDIUM.getMaxSize());

        // Check word display mask is correct ( = same size as wordTOfine + only "=" characters)
        String wordDisplay = Pendu.instance.getCurrentWordState();
        checkSizeWordTest(wordDisplay, EnumDifficulty.MEDIUM.getMinSize(), EnumDifficulty.MEDIUM.getMaxSize());
        Assert.assertEquals(wordTofine.length(), wordDisplay.length());
        Assert.assertEquals(wordDisplay.length(), wordDisplay.length() - (wordDisplay.replace("=", "")).length());
    }

}
