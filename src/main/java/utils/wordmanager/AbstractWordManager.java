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
    protected transient List<String> wordArrayLevel01;

    /**
     * Word array for difficulty two.
     */
    protected transient List<String> wordArrayLevel02;

    /**
     * Get a Random Word according to difficulty selected.
     *
     * @param difficulty difficulty choosen
     * @return String
     */
    public String getRandomWordForDifficulty(EnumDifficulty difficulty) {
        Random rand = new Random();
        String upperCaseWordToRet = "";
        switch (difficulty) {
            case EASY:
                if (!wordArrayLevel01.isEmpty()) {
                    upperCaseWordToRet = wordArrayLevel01.get(rand.nextInt(wordArrayLevel01.size()));
                    wordArrayLevel01.remove(upperCaseWordToRet);
                }
                break;
            case MEDIUM:
                if (!wordArrayLevel02.isEmpty()) {
                    upperCaseWordToRet = wordArrayLevel02.get(rand.nextInt(wordArrayLevel02.size()));
                    wordArrayLevel02.remove(upperCaseWordToRet);
                }
                break;
            case HARD:
            default:
                List<String> list = new ArrayList();
                list.addAll(wordArrayLevel01);
                list.addAll(wordArrayLevel02);
                if (!list.isEmpty()) {
                    upperCaseWordToRet = list.get(rand.nextInt(list.size()));
                    if (upperCaseWordToRet.length() < EnumDifficulty.MEDIUM.getMinSize()) {
                        wordArrayLevel01.remove(upperCaseWordToRet);
                    } else {
                        wordArrayLevel02.remove(upperCaseWordToRet);
                    }
                }
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
