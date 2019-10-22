import pendu.Pendu;
import utils.KeyboardManager;

public class Main {

    private static boolean gameRunning = false, continueGame = true;

    public static void main(String[] args) {
        System.out.println("Welcome to Pendastick\n___________________________");
        startPlaying();
    }

    /**
     * Main logic of how run the program
     */
    private static void startPlaying() {
        while (gameRunning || continueGame) {
            // Do you want to start Playing
            if (!gameRunning) {
                askToPlay();
            }
            if (gameRunning) {
                Pendu.instance.startGame(askDifficulty());
                gameRunning = false;
            }
        }

    }

    /**
     * Ask to start game and change global values
     */
    private static void askToPlay() {
        boolean saisiInvalid = true;
        String s;
        while (saisiInvalid) {
            s = KeyboardManager.instance.readCharacter("Do you want to start a new game ? (Y/N)");
            if (KeyboardManager.instance.isSame(s, "Y")) {
                saisiInvalid = false;
                gameRunning = true;
            } else if (KeyboardManager.instance.isSame(s, "N")) {
                continueGame = false;
                gameRunning = false;
                saisiInvalid = false;
                System.out.println("Goodbye !");
            }
        }
    }

    /**
     * Ask game difficulty
     */
    private static int askDifficulty() {
        return KeyboardManager.instance.readNumber("Choose difficulty :\n 1 - Easy (3 or 4 characters)\n 2 - Normal (5 or more characters)", 1, 2);
    }
}
