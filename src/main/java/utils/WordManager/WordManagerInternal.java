package utils.WordManager;

import java.util.ArrayList;

class WordManagerInternal extends WordManagerBase {

    /**
     * Create lists of internals words
     */
    WordManagerInternal() {
        wordArrayLevel01 = new ArrayList<>();
        wordArrayLevel02 = new ArrayList<>();
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

}