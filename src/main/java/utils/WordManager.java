package utils;

import java.util.ArrayList;
import java.util.Random;

/**
 * Use this word manager for words
 */
public class WordManager {

    /**
     * Word array for difficulty one
     */
    private ArrayList<String> wordArrayLevel01;

    /**
     * Word array for difficulty two
     */
    private ArrayList<String> wordArrayLevel02;

    /**
     * instance de gestion des mots
     */
    public static WordManager instance = new WordManager();

    private WordManager() {
        wordArrayLevel01 = new ArrayList<>();
        wordArrayLevel02 = new ArrayList<>();
        //    generateWordArray();
        generateStaticWordArray();
    }

    /**
     * Create static list for early app release
     */
    private void generateStaticWordArray() {
        // Difficulty 01
        wordArrayLevel01.add("ETE");
        wordArrayLevel01.add("PAPA");
        wordArrayLevel01.add("TEST");
        wordArrayLevel01.add("TOI");
        wordArrayLevel01.add("VOUS");

        // Difficulty 02
        wordArrayLevel02.add("PENDU");
        wordArrayLevel02.add("BONJOUR");
        wordArrayLevel02.add("SOLDAT");
        wordArrayLevel02.add("INFORMATIQUE");
        wordArrayLevel02.add("ARGENT");
    }

    /**
     * Get a random word corresponding to the selected difficulty
     *
     * @param difficulty difficulty choosen
     * @return a random word for this difficulty
     */
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

    private void generateWordArray() {
    }

    public ArrayList<String> getWordArrayLevel01() {
        return wordArrayLevel01;
    }

    public ArrayList<String> getWordArrayLevel02() {
        return wordArrayLevel02;
    }
}

