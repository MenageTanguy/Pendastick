package utils.WordManager;

import java.util.ArrayList;
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
        switch (difficulty) {
            case 1:
                return wordArrayLevel01.get(rand.nextInt(wordArrayLevel01.size()));
            case 2:
            default:
                return wordArrayLevel02.get(rand.nextInt(wordArrayLevel02.size()));
        }
    }

    public ArrayList<String> getWordArrayLevel01() {
        return wordArrayLevel01;
    }

    public ArrayList<String> getWordArrayLevel02() {
        return wordArrayLevel02;
    }

}