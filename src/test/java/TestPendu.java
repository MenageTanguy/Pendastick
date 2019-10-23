import org.junit.Assert;
import org.junit.Test;
import utils.DrawManager;
import utils.WordManager.WordManager;

/**
 * Class test for pendu
 */
public class TestPendu {

    /**
     * Test difficulty level 01
     * check word quality
     * Test 5 randoms word for difficulty 01
     */
    @Test
    public void testPenduDifficulty01() {
        System.out.println("testPenduDifficulty01, check size word");
        int difficulty = 1;
        int minLength = 3;
        int maxLenght = 4;
        checkSizeWordTest(WordManager.instance.getRandomWordForDifficulty(difficulty), minLength, maxLenght);
        checkSizeWordTest(WordManager.instance.getRandomWordForDifficulty(difficulty), minLength, maxLenght);
        checkSizeWordTest(WordManager.instance.getRandomWordForDifficulty(difficulty), minLength, maxLenght);
        checkSizeWordTest(WordManager.instance.getRandomWordForDifficulty(difficulty), minLength, maxLenght);
        checkSizeWordTest(WordManager.instance.getRandomWordForDifficulty(difficulty), minLength, maxLenght);
    }

    /**
     * Test difficulty level 02
     * check word quality
     * Test 5 randoms word for difficulty 02
     */
    @Test
    public void testPenduDifficulty02() {
        System.out.println("testPenduDifficulty02, check size word");
        int difficulty = 2;
        int minLength = 5;
        int maxLenght = Integer.MAX_VALUE;
        checkSizeWordTest(WordManager.instance.getRandomWordForDifficulty(difficulty), minLength, maxLenght);
        checkSizeWordTest(WordManager.instance.getRandomWordForDifficulty(difficulty), minLength, maxLenght);
        checkSizeWordTest(WordManager.instance.getRandomWordForDifficulty(difficulty), minLength, maxLenght);
        checkSizeWordTest(WordManager.instance.getRandomWordForDifficulty(difficulty), minLength, maxLenght);
        checkSizeWordTest(WordManager.instance.getRandomWordForDifficulty(difficulty), minLength, maxLenght);
    }

    /**
     * Test if a random word is included in word list
     */
    @Test
    public void testPenduRandomWord() {
        // Difficulty 01
        System.out.println("testPenduRandomWord, check if word is random word is contain in the good list");
        System.out.println("Test difficulty 1 list..");
        Assert.assertTrue("This word is not contain in the list !", WordManager.instance.getWordArrayLevel01().contains(WordManager.instance.getRandomWordForDifficulty(1)));
        Assert.assertTrue("This word is not contain in the list !", WordManager.instance.getWordArrayLevel01().contains(WordManager.instance.getRandomWordForDifficulty(1)));
        Assert.assertTrue("This word is not contain in the list !", WordManager.instance.getWordArrayLevel01().contains(WordManager.instance.getRandomWordForDifficulty(1)));
        System.out.println(".. OK");
        System.out.println("Test difficulty 2 list..");
        // Difficulty 02
        Assert.assertTrue("This word is not contain in the list !", WordManager.instance.getWordArrayLevel02().contains(WordManager.instance.getRandomWordForDifficulty(2)));
        Assert.assertTrue("This word is not contain in the list !", WordManager.instance.getWordArrayLevel02().contains(WordManager.instance.getRandomWordForDifficulty(2)));
        Assert.assertTrue("This word is not contain in the list !", WordManager.instance.getWordArrayLevel02().contains(WordManager.instance.getRandomWordForDifficulty(2)));
        System.out.println(".. OK");
    }

    /**
     * Check if draw is the good one for a specific nb of failure.
     */
    @Test
    public void testPenduDrawIsGood(){
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
