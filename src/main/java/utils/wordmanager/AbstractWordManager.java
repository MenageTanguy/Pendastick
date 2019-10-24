package utils.wordmanager;

import utils.enums.EnumDifficulty;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

/**
 * Abstract class for WordManager
 */
public abstract class AbstractWordManager implements WordManager {

    /**
     * Word array for difficulty one
     */
    protected ArrayList<String> wordArrayLevel01;

    /**
     * Word array for difficulty two
     */
    protected ArrayList<String> wordArrayLevel02;

    public String getRandomWordForDifficulty(EnumDifficulty difficulty) {
        Random rand = new Random();
        String upperCaseWordToRet;
        switch (difficulty) {
            case EASY:
                upperCaseWordToRet = wordArrayLevel01.get(rand.nextInt(wordArrayLevel01.size()));
                break;
            case MEDIUM:
            default:
                upperCaseWordToRet = wordArrayLevel02.get(rand.nextInt(wordArrayLevel02.size()));
                break;
        }
        return upperCaseWordToRet.toUpperCase(Locale.getDefault());
    }

    public ArrayList<String> getWordArrayLevel01() {
        return wordArrayLevel01;
    }

    public ArrayList<String> getWordArrayLevel02() {
        return wordArrayLevel02;
    }

}
