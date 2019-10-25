package main;

import pendu.Application;

import java.util.Arrays;

/**
 * Main class of the game, run the program and game logic.
 */
public final class MainGame {

    private MainGame() {
    }

    /**
     * Main class to launch program.
     *
     * @param args args to launch
     */
    public static void main(String[] args) {
        System.out.println("Welcome to Pendastick\n___________________________" + Arrays.toString(args));
        Application application = new Application();
        application.startPlaying();
    }

}
