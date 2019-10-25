package pendu;

import utils.KeyboardUtils;
import utils.enums.EnumDifficulty;
import utils.wordmanager.WordManager;
import utils.wordmanager.WordManagerFactory;

public class Application {

    /**
     * State of game (is a game running ?).
     */
    private boolean gameRunning;
    /**
     * State of program, if false, program terminates.
     */
    private boolean continueGame;

    /**
     * List of state game of all players.
     */
    private Boolean[] playersCanPlay;

    /**
     * List of all players name.
     */
    private String[] playersName;

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
                int nbPlayer = askNbPlayers();
                generatePlayersName(nbPlayer);
                WordManager wordManager = askWordDictionnary();
                EnumDifficulty difficulty = askDifficulty(wordManager);
                if (difficulty != null) {
                    boolean gameOver = false;
                    initPlayersList(nbPlayer);
                    while (!gameOver) {
                        System.out.println("Time to find a new word ! Good luck.");
                        String wordToFind = wordManager.getRandomWordForDifficulty(difficulty);
                        for (int i = 0; i < nbPlayer; i++) {
                            if (playersCanPlay[i]) {
                                System.out.println("Let's go player " + playersName[i]);
                                Pendu.instance.initGameValues(difficulty, wordToFind);
                                playersCanPlay[i] = Pendu.instance.startGame();
                            }
                        }
                        gameOver = checkStatePlayers(nbPlayer);
                    }
                }
                gameRunning = false;
            }
        }

    }

    /**
     * Keyboard input to generate all players name.
     *
     * @param nbPlayer nb of player
     */
    private void generatePlayersName(int nbPlayer) {
        playersName = new String[nbPlayer];
        for (int i = 0; i < nbPlayer; i++) {
            playersName[i] = KeyboardUtils.readString("Please enter name for player " + (i + 1));
        }
    }

    /**
     * Check state of players.
     *
     * @param nbPlayer nb of players
     * @return true if all players looses or if only one player remain.
     */
    private boolean checkStatePlayers(int nbPlayer) {
        int lastPlayerRemain = -1;
        int countPlayers = 0;
        boolean result = false;
        for (int i = 0; i < nbPlayer; i++) {
            if (playersCanPlay[i]) {
                lastPlayerRemain = i;
            } else {
                countPlayers++;
            }
        }
        if (countPlayers == nbPlayer) {
            System.out.println("No one won ! Try again");
            result = true;
        } else if (countPlayers == nbPlayer - 1) {
            System.out.println(playersName[lastPlayerRemain] + " win ! Congratulations");
            result = true;
        }
        return result;
    }

    /**
     * Init players state list.
     *
     * @param nbPlayer nb of player
     */
    private void initPlayersList(int nbPlayer) {
        playersCanPlay = new Boolean[nbPlayer];
        for (int i = 0; i < nbPlayer; i++) {
            playersCanPlay[i] = true;
        }
    }

    /**
     * Ask nb of players to user.
     *
     * @return nbOfPlayer
     */
    private int askNbPlayers() {
        return KeyboardUtils.readNumber("Choose player number (1-6)", 1, 6);
    }

    /**
     * Ask to start game and change global values.
     */
    private void askToPlay() {
        boolean saisiInvalid = true;
        String input;
        while (saisiInvalid) {
            input = KeyboardUtils.readCharacter("Do you want to start a new game ? (Y/N)");
            if (KeyboardUtils.isSame(input, "Y")) {
                saisiInvalid = false;
                gameRunning = true;
            } else if (KeyboardUtils.isSame(input, "N")) {
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
        boolean saisiInvalid = true;
        boolean normalMode = true;
        EnumDifficulty resultValue = null;
        String input;
        while (saisiInvalid) {
            input = KeyboardUtils.readCharacter("Do you want to play NORMAL or HARD MODE ? (N/H)");
            if (KeyboardUtils.isSame(input, "N")) {
                saisiInvalid = false;
            } else if (KeyboardUtils.isSame(input, "H")) {
                saisiInvalid = false;
                normalMode = false;
            }
        }
        if (normalMode) {
            if (wordManager.getWordArrayLevel01().isEmpty() && wordManager.getWordArrayLevel02().isEmpty()) {
                System.out.println("No word find !");
            } else if (wordManager.getWordArrayLevel01().isEmpty() && !wordManager.getWordArrayLevel02().isEmpty()) {
                System.out.println("Only Normal mode is available, let's go !");
                resultValue = EnumDifficulty.MEDIUM;
            } else if (!wordManager.getWordArrayLevel01().isEmpty() && wordManager.getWordArrayLevel02().isEmpty()) {
                System.out.println("Only Normal mode is available, let's go !");
                resultValue = EnumDifficulty.EASY;
            } else {
                resultValue = EnumDifficulty.getEnumByValue(KeyboardUtils.readNumber(
                        "Choose difficulty :\n"
                                + " 1 - Easy (3 or 4 characters)\n 2 - Normal (5 or more characters)",
                        EnumDifficulty.EASY.getDifficultyValue(), EnumDifficulty.MEDIUM.getDifficultyValue()));
            }
        } else {
            resultValue = EnumDifficulty.HARD;
        }
        return resultValue;
    }


    /**
     * Method to ask word management to user.
     */
    private WordManager askWordDictionnary() {
        int dictionnaryChoice = KeyboardUtils.readNumber("Choose word dictionnary :\n 1 - "
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
        String inputPath;
        if (dictionnaryChoice != EnumDifficulty.EASY.getDifficultyValue()) {
            inputPath = KeyboardUtils.readPath("Please enter a valid path for your custom dictionnary");
        } else {
            inputPath = "";
        }
        return inputPath;
    }

}