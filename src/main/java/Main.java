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
        }

    }

    /**
     * Ask to start game and change global values
     */
    private static void askToPlay() {
        System.out.println("Do you want to start a new game ? (Y/N)");
        // TODO code
    }
}
