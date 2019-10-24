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

    /**
     * Init game, add some false letters + find the word
     * Easy difficulty
     */
    @Test
    public void testAddLetterAndSuccessWordEasy() {
        System.out.println("testAddLetterAndSuccessWordEasy --> init and add letter");
        WordManager wordManager = WordManagerFactory.getInstance().getWordManager(true, "");
        Pendu.instance.initGameValues(EnumDifficulty.EASY, wordManager);
        Pendu.instance.displayInfo();

        // Add 3 possible false letters 'W' 'Z' 'Y'
        Pendu.instance.checkLetter("W");
        Pendu.instance.checkLetter("Z");
        Pendu.instance.checkLetter("Y");
        // Add all good letters
        char[] array = Pendu.instance.getWordTofind().toCharArray();
        for (char c : array) {
            Pendu.instance.checkLetter("" + c);
        }
        Assert.assertTrue(Pendu.instance.isWordFind());
        // On peut start le game on ne passera pas la loop si le mot est trouvé
        Assert.assertTrue(Pendu.instance.startGame());
    }

    /**
     * Init game, add some false letters + find the word
     * Medium difficulty
     */
    @Test
    public void testAddLetterAndSuccessWordMedium() {
        System.out.println("testAddLetterAndSuccessWordMedium --> init and add letter");
        WordManager wordManager = WordManagerFactory.getInstance().getWordManager(true, "");
        Pendu.instance.initGameValues(EnumDifficulty.MEDIUM, wordManager);
        Pendu.instance.displayInfo();

        // Add 3 possible false letters 'W' 'Z' 'Y'
        Pendu.instance.checkLetter("W");
        Pendu.instance.checkLetter("Z");
        Pendu.instance.checkLetter("Y");
        // Add all good letters
        char[] array = Pendu.instance.getWordTofind().toCharArray();
        for (char c : array) {
            Pendu.instance.checkLetter("" + c);
        }
        Assert.assertTrue(Pendu.instance.isWordFind());
        // On peut start le game on ne passera pas la loop si le mot est trouvé
        Assert.assertTrue(Pendu.instance.startGame());
    }


    /**
     * Init game, add false letters and check game fail
     * Easy difficulty
     */
    @Test
    public void testAddLetterAndFailWordEasy() {
        System.out.println("testAddLetterAndFailWordEasy --> init and add letter");
        WordManager wordManager = WordManagerFactory.getInstance().getWordManager(true, "");
        Pendu.instance.initGameValues(EnumDifficulty.EASY, wordManager);
        Pendu.instance.displayInfo();


        // Add 4 possible false letters 'W' 'Z' 'Y' 'X' 'V'
        for (int i = 0; i < 5; i++) {
            Pendu.instance.checkLetter("W");
            Pendu.instance.checkLetter("Z");
            Pendu.instance.checkLetter("Y");
            Pendu.instance.checkLetter("X");
            Pendu.instance.checkLetter("V");
        }
        Assert.assertFalse(Pendu.instance.isWordFind());
        // On peut start le game on ne passera pas la loop si le mot est trouvé
        Assert.assertFalse(Pendu.instance.startGame());
    }

    /**
     * Init game, add false letters and check game fail
     * Easy difficulty
     */
    @Test
    public void testAddLetterAndFailWordMedium() {
        System.out.println("testAddLetterAndFailWordMedium --> init and add letter");
        WordManager wordManager = WordManagerFactory.getInstance().getWordManager(true, "");
        Pendu.instance.initGameValues(EnumDifficulty.EASY, wordManager);
        Pendu.instance.displayInfo();

        // Add 4 possible false letters 'W' 'Z' 'Y' 'X' 'V'
        for (int i = 0; i < 5; i++) {
            Pendu.instance.checkLetter("W");
            Pendu.instance.checkLetter("Z");
            Pendu.instance.checkLetter("Y");
            Pendu.instance.checkLetter("X");
            Pendu.instance.checkLetter("V");
        }
        Assert.assertFalse(Pendu.instance.isWordFind());
        // On peut start le game on ne passera pas la loop si le mot est trouvé
        Assert.assertFalse(Pendu.instance.startGame());
    }
}
