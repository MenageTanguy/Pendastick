package test;

import org.junit.Assert;
import org.junit.Test;
import utils.DrawUtils;
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
        Assert.assertEquals("Draw is not good... ", DrawUtils.getDrawForThisLooseNumber(0), DrawUtils.PENDU_STATE_0);
        Assert.assertEquals("Draw is not good... ", DrawUtils.getDrawForThisLooseNumber(1), DrawUtils.PENDU_STATE_1);
        Assert.assertEquals("Draw is not good... ", DrawUtils.getDrawForThisLooseNumber(2), DrawUtils.PENDU_STATE_2);
        Assert.assertEquals("Draw is not good... ", DrawUtils.getDrawForThisLooseNumber(3), DrawUtils.PENDU_STATE_3);
        Assert.assertEquals("Draw is not good... ", DrawUtils.getDrawForThisLooseNumber(4), DrawUtils.PENDU_STATE_4);
        Assert.assertEquals("Draw is not good... ", DrawUtils.getDrawForThisLooseNumber(5), DrawUtils.PENDU_STATE_5);
        Assert.assertEquals("Draw is not good... ", DrawUtils.getDrawForThisLooseNumber(6), DrawUtils.PENDU_STATE_6);
        Assert.assertEquals("Draw is not good... ", DrawUtils.getDrawForThisLooseNumber(7), DrawUtils.PENDU_STATE_7);
        Assert.assertEquals("Draw is not good... ", DrawUtils.getDrawForThisLooseNumber(8), DrawUtils.PENDU_STATE_8);
        Assert.assertEquals("Draw is not good... ", DrawUtils.getDrawForThisLooseNumber(9), DrawUtils.PENDU_STATE_9);
        Assert.assertEquals("Draw is not good... ", DrawUtils.getDrawForThisLooseNumber(10), DrawUtils.PENDU_STATE_10);

    }

}