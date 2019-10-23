package utils.WordManager;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public abstract class WordManagerBase implements WordManager {

    /**
     * Word array for difficulty one
     */
    ArrayList<String> wordArrayLevel01;

    /**
     * Word array for difficulty two
     */
    ArrayList<String> wordArrayLevel02;

    public String getRandomWordForDifficulty(int difficulty) {
        Random rand = new Random();
        String upperCaseWordToRet;
        switch (difficulty) {
            case 1:
                upperCaseWordToRet = wordArrayLevel01.get(rand.nextInt(wordArrayLevel01.size()));
                break;
            case 2:
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