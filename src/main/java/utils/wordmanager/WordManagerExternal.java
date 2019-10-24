package utils.wordmanager;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * Generate Words list using file
 */
class WordManagerExternal extends AbstractWordManager {

    /**
     * Instance of WordManager for external files
     *
     * @param pathForExternal pathForParam
     */
    WordManagerExternal(String pathForExternal) {
        super();
        wordArrayLevel01 = new ArrayList<>();
        wordArrayLevel02 = new ArrayList<>();
        List<String> inputList;

        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(pathForExternal))) {
            //br returns as stream and convert it into a List
            inputList = bufferedReader.lines().collect(Collectors.toList());
            addWordIntoGoodList((ArrayList<String>) inputList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * method to add a list of word into the good difficulty array
     *
     * @param wordList list of word
     */
    private void addWordIntoGoodList(List<String> wordList) {
        for (String word : wordList) {
            word = word.trim().toUpperCase(Locale.getDefault());
            if (!word.matches("[a-zA-Z]+")) {
                continue;
            }
            // 1 & 2 chars words are ignored
            if (word.length() > 2) {
                System.out.println("Word to add : " + word);
                // Add to list 1
                if (word.length() < 5) {
                    wordArrayLevel01.add(word.toUpperCase(Locale.getDefault()));
                } else {
                    wordArrayLevel02.add(word.toUpperCase(Locale.getDefault()));
                }
            }
        }
    }

}
