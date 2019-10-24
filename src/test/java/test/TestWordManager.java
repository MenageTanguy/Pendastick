package test;

import org.junit.Assert;
import org.junit.Test;
import utils.DrawManager;
import utils.enums.EnumDifficulty;
import utils.wordmanager.WordManager;
import utils.wordmanager.WordManagerFactory;

/**
 * Class test for pendu
 */
public class TestWordManager extends TestUtils {


    /**
     * Test difficulty level 01
     * check word quality
     * Test 5 randoms word for difficulty 01
     */
    @Test
    public void testPenduDifficulty01Internal() {
        WordManager wordManager = WordManagerFactory.getInstance().getWordManager(true, "");
        System.out.println("testPenduDifficulty01Internal, check size word");
        checkWordDifficulty(wordManager, EnumDifficulty.EASY);
    }

    /**
     * Test difficulty level 02
     * check word quality
     * Test 5 randoms word for difficulty 02
     */
    @Test
    public void testPenduDifficulty02Internal() {
        WordManager wordManager = WordManagerFactory.getInstance().getWordManager(false, PATH_TO_FILE_TEST);
        System.out.println("testPenduDifficulty02Internal, check size word");
        checkWordDifficulty(wordManager, EnumDifficulty.EASY);
    }

    /**
     * Test difficulty level 01
     * check word quality
     * Test 5 randoms word for difficulty 01
     */
    @Test
    public void testPenduDifficulty01External() {
        WordManager wordManager = WordManagerFactory.getInstance().getWordManager(false, PATH_TO_FILE_TEST);
        System.out.println("testPenduDifficulty01External, check size word");
        checkWordDifficulty(wordManager, EnumDifficulty.MEDIUM);
    }

    /**
     * Test difficulty level 02
     * check word quality
     * Test 5 randoms word for difficulty 02
     */
    @Test
    public void testPenduDifficulty02External() {
        WordManager wordManager = WordManagerFactory.getInstance().getWordManager(false, PATH_TO_FILE_TEST);
        System.out.println("testPenduDifficulty02External, check size word");
        checkWordDifficulty(wordManager, EnumDifficulty.MEDIUM);
    }


    /**
     * Test if a random word is included in word list
     */
    @Test
    public void testPenduRandomWordInternal() {
        WordManager wordManager = WordManagerFactory.getInstance().getWordManager(true, "");
        checkWordIntoManager(wordManager);
    }

    /**
     * Test if a random word is included in word list
     */
    @Test
    public void testPenduRandomWordExternal() {
        WordManager wordManager = WordManagerFactory.getInstance().getWordManager(false, PATH_TO_FILE_TEST);
        checkWordIntoManager(wordManager);
    }


    /**
     * Check if draw is the good one for a specific nb of failure.
     */
    @Test
    public void testPenduDrawIsGood() {
        System.out.println("testPenduDrawIsGood check if draw is good !");
        Assert.assertEquals("Draw is not good... ", DrawManager.instance.getDrawForThisLooseNumber(0), DrawManager.PENDU_STATE_0);
        Assert.assertEquals("Draw is not good... ", DrawManager.instance.getDrawForThisLooseNumber(1), DrawManager.PENDU_STATE_1);
        Assert.assertEquals("Draw is not good... ", DrawManager.instance.getDrawForThisLooseNumber(2), DrawManager.PENDU_STATE_2);
        Assert.assertEquals("Draw is not good... ", DrawManager.instance.getDrawForThisLooseNumber(3), DrawManager.PENDU_STATE_3);
        Assert.assertEquals("Draw is not good... ", DrawManager.instance.getDrawForThisLooseNumber(4), DrawManager.PENDU_STATE_4);
        Assert.assertEquals("Draw is not good... ", DrawManager.instance.getDrawForThisLooseNumber(5), DrawManager.PENDU_STATE_5);
        Assert.assertEquals("Draw is not good... ", DrawManager.instance.getDrawForThisLooseNumber(6), DrawManager.PENDU_STATE_6);
        Assert.assertEquals("Draw is not good... ", DrawManager.instance.getDrawForThisLooseNumber(7), DrawManager.PENDU_STATE_7);
        Assert.assertEquals("Draw is not good... ", DrawManager.instance.getDrawForThisLooseNumber(8), DrawManager.PENDU_STATE_8);
        Assert.assertEquals("Draw is not good... ", DrawManager.instance.getDrawForThisLooseNumber(9), DrawManager.PENDU_STATE_9);
        Assert.assertEquals("Draw is not good... ", DrawManager.instance.getDrawForThisLooseNumber(10), DrawManager.PENDU_STATE_10);

    }

}