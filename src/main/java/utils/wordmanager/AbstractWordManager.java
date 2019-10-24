package utils.wordmanager;

import utils.enums.EnumDifficulty;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/**
 * Abstract class for WordManager.
 */
public abstract class AbstractWordManager implements WordManager {

    /**
     * Word array for difficulty .
     */
    protected List<String> wordArrayLevel01;

    /**
     * Word array for difficulty two.
     */
    protected List<String> wordArrayLevel02;

    /**
     * Get a Random Word according to difficulty selected.
     *
     * @param difficulty difficulty choosen
     * @return String
     */
    public String getRandomWordForDifficulty(EnumDifficulty difficulty) {
        Random rand = new Random();
        String upperCaseWordToRet;
        switch (difficulty) {
            case EASY:
                upperCaseWordToRet = wordArrayLevel01.get(rand.nextInt(wordArrayLevel01.size()));
                break;
            case MEDIUM:
                upperCaseWordToRet = wordArrayLevel02.get(rand.nextInt(wordArrayLevel02.size()));
                break;
            default:
            case HARD:
                List<String> list = new ArrayList();
                list.addAll(wordArrayLevel01);
                list.addAll(wordArrayLevel02);
                upperCaseWordToRet = list.get(rand.nextInt(list.size()));
                break;
        }
        return upperCaseWordToRet.toUpperCase(Locale.getDefault());
    }

    /**
     * Returns a list of word for the first difficulty.
     *
     * @return List
     */
    public List<String> getWordArrayLevel01() {
        return wordArrayLevel01;
    }

    /**
     * Returns a list of word for second difficulty.
     *
     * @return Lsit
     */
    public List<String> getWordArrayLevel02() {
        return wordArrayLevel02;
    }

}
