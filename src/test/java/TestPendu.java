import org.junit.Assert;
import org.junit.Test;
import utils.DrawManager;
import utils.WordManager.WordManager;
import utils.WordManager.WordManagerFactory;

/**
 * Class test for pendu
 */
public class TestPendu {

    private static final String PATH_TO_FILE_TEST = "PATH_TO_FILE_TEST";


    /**
     * Test difficulty level 01
     * check word quality
     * Test 5 randoms word for difficulty 01
     */
    @Test
    public void testPenduDifficulty01Internal() {
        WordManager wordManager = WordManagerFactory.getInstance().getWordManager(true, "");
        System.out.println("testPenduDifficulty01Internal, check size word");
        checkWordDifficulty(wordManager, 1, 3, 4);
    }

    /**
     * Test difficulty level 02
     * check word quality
     * Test 5 randoms word for difficulty 02
     */
    @Test
    public void testPenduDifficulty02Internal() {
        WordManager wordManager = WordManagerFactory.getInstance().getWordManager(true, "");
        System.out.println("testPenduDifficulty02Internal, check size word");
        checkWordDifficulty(wordManager, 2, 5, Integer.MAX_VALUE);
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
        checkWordDifficulty(wordManager, 1, 3, 4);
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
        checkWordDifficulty(wordManager, 2, 5, Integer.MAX_VALUE);
    }


    /**
     * Check Word difficulty using params
     *
     * @param wordManager word manager to test
     * @param difficulty  difficulty  to test
     * @param minLength   min word size
     * @param maxLenght   max word size
     */
    private void checkWordDifficulty(WordManager wordManager, int difficulty, int minLength, int maxLenght) {
        checkSizeWordTest(wordManager.getRandomWordForDifficulty(difficulty), minLength, maxLenght);
        checkSizeWordTest(wordManager.getRandomWordForDifficulty(difficulty), minLength, maxLenght);
        checkSizeWordTest(wordManager.getRandomWordForDifficulty(difficulty), minLength, maxLenght);
        checkSizeWordTest(wordManager.getRandomWordForDifficulty(difficulty), minLength, maxLenght);
        checkSizeWordTest(wordManager.getRandomWordForDifficulty(difficulty), minLength, maxLenght);
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
     * Check if random word selector get words existing into
     *
     * @param wordManager wordManager to test
     */
    private void checkWordIntoManager(WordManager wordManager) {
        // Difficulty 01
        System.out.println("testPenduRandomWordInternal, check if word is random word is contain in the good list");
        System.out.println("Test difficulty 1 list..");
        Assert.assertTrue("This word is not contain in the list !", wordManager.getWordArrayLevel01().contains(wordManager.getRandomWordForDifficulty(1)));
        Assert.assertTrue("This word is not contain in the list !", wordManager.getWordArrayLevel01().contains(wordManager.getRandomWordForDifficulty(1)));
        Assert.assertTrue("This word is not contain in the list !", wordManager.getWordArrayLevel01().contains(wordManager.getRandomWordForDifficulty(1)));
        System.out.println(".. OK");
        System.out.println("Test difficulty 2 list..");
        // Difficulty 02
        Assert.assertTrue("This word is not contain in the list !", wordManager.getWordArrayLevel02().contains(wordManager.getRandomWordForDifficulty(2)));
        Assert.assertTrue("This word is not contain in the list !", wordManager.getWordArrayLevel02().contains(wordManager.getRandomWordForDifficulty(2)));
        Assert.assertTrue("This word is not contain in the list !", wordManager.getWordArrayLevel02().contains(wordManager.getRandomWordForDifficulty(2)));
        System.out.println(".. OK");
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

    /**
     * Check if a word have expected size
     *
     * @param randomWordForDifficulty word to test
     * @param minLength               min Size
     * @param maxLenght               max Size
     */
    private void checkSizeWordTest(String randomWordForDifficulty, int minLength, int maxLenght) {
        boolean isGoodSize = randomWordForDifficulty.length() >= minLength && randomWordForDifficulty.length() <= maxLenght;
        System.out.println("Word : " + randomWordForDifficulty + "\nSize = " + randomWordForDifficulty.length() + "\n");
        Assert.assertTrue("Word " + randomWordForDifficulty + " have not expected size ! ", isGoodSize);
    }

}
