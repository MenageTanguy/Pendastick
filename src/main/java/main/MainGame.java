package main;

import pendu.Application;

/**
 * Main class of the game, run the program and game logic.
 */
public class MainGame {

    /**
     * Main class to launch program.
     *
     * @param args args to launch
     */
    public static void main(String[] args) {
        System.out.println("Welcome to Pendastick\n_______________n____________");
        Application application = new Application();
        application.startPlaying();
    }

}
