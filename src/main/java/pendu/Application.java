package pendu;

import utils.KeyboardManager;
import utils.enums.EnumDifficulty;
import utils.wordmanager.WordManager;
import utils.wordmanager.WordManagerFactory;

public class Application {

    /**
     * State of game (is a game running ? )
     */
    private boolean gameRunning;
    /**
     * State of program, if false, program terminates.
     */
    private boolean continueGame;

    public Application() {
        this.continueGame = true;
        this.gameRunning = false;
    }

    /**
     * main.MainGame logic of how run the program.
     */
    public void startPlaying() {
        while (gameRunning || continueGame) {
            // Do you want to start Playing
            if (!gameRunning) {
                askToPlay();
            }
            if (gameRunning) {
                WordManager wordManager = askWordDictionnary();
                EnumDifficulty difficulty = askDifficulty(wordManager);
                if (difficulty != null) {
                    Pendu.instance.initGameValues(difficulty, wordManager);
                    Pendu.instance.startGame();
                }
                gameRunning = false;
            }
        }

    }

    /**
     * Ask to start game and change global values.
     */
    private void askToPlay() {
        boolean saisiInvalid = true;
        String input;
        while (saisiInvalid) {
            input = KeyboardManager.instance.readCharacter("Do you want to start a new game ? (Y/N)");
            if (KeyboardManager.instance.isSame(input, "Y")) {
                saisiInvalid = false;
                gameRunning = true;
            } else if (KeyboardManager.instance.isSame(input, "N")) {
                continueGame = false;
                gameRunning = false;
                saisiInvalid = false;
                System.out.println("Goodbye !");
            }
        }
    }

    /**
     * Ask game difficulty.
     *
     * @param wordManager wordManager used
     */
    private EnumDifficulty askDifficulty(WordManager wordManager) {
        EnumDifficulty resultValue = null;
        if (wordManager.getWordArrayLevel01().isEmpty() && wordManager.getWordArrayLevel02().isEmpty()) {
            System.out.println("No word find !");
        } else if (wordManager.getWordArrayLevel01().isEmpty() && !wordManager.getWordArrayLevel02().isEmpty()) {
            System.out.println("Only Normal mode is available, let's go !");
            resultValue = EnumDifficulty.MEDIUM;
        } else if (!wordManager.getWordArrayLevel01().isEmpty() && wordManager.getWordArrayLevel02().isEmpty()) {
            System.out.println("Only Normal mode is available, let's go !");
            resultValue = EnumDifficulty.EASY;
        } else {
            resultValue = EnumDifficulty.getEnumByValue(KeyboardManager.instance.readNumber(
                    "Choose difficulty :\n"
                            + " 1 - Easy (3 or 4 characters)\n 2 - Normal (5 or more characters)",
                    EnumDifficulty.EASY.getDifficultyValue(), EnumDifficulty.MEDIUM.getDifficultyValue()));
        }
        return resultValue;
    }


    /**
     * Method to ask word management to user.
     */
    private WordManager askWordDictionnary() {
        int dictionnaryChoice = KeyboardManager.instance.readNumber("Choose word dictionnary :\n 1 - "
                + "Internal (Program dictionnary)\n 2 - Custom (Use your own file)", 1, 2);
        return WordManagerFactory.getInstance().getWordManager(
                dictionnaryChoice == EnumDifficulty.EASY.getDifficultyValue(), askForPath(dictionnaryChoice));

    }

    /**
     * Ask path to user.
     *
     * @param dictionnaryChoice if 1 = internal mode and return ""
     * @return valid path
     */
    private String askForPath(int dictionnaryChoice) {
        String inputPath = "";
        if (dictionnaryChoice != EnumDifficulty.EASY.getDifficultyValue()) {
            inputPath = KeyboardManager.instance.readPath("Please enter a valid path for your custom dictionnary");
        }
        return inputPath;
    }


}