package utils;

/**
 * Use this class manager to draw Pendu
 */
public class DrawManager {

    public static DrawManager INSTANCE = new DrawManager();


    private static final String PENDU_STATE_0 = "\n\n\n\n\n\n\n\n\n\n";
    private static final String PENDU_STATE_1 = "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "  __|________\n";
    private static final String PENDU_STATE_2 = "\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "  __|________";
    private static final String PENDU_STATE_3 = "     _____________\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "  __|________";
    private static final String PENDU_STATE_4 = "     _____________\n" +
            "    | / \n" +
            "    |/ \n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            " ___|________";
    private static final String PENDU_STATE_5 = "     _____________\n" +
            "    | /         |\n" +
            "    |/          |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "  __|________";
    private static final String PENDU_STATE_6 = "     _____________\n" +
            "    | /         |\n" +
            "    |/          |\n" +
            "    |           O\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "  __|________";
    private static final String PENDU_STATE_7 = "     _____________\n" +
            "    | /         |\n" +
            "    |/          |\n" +
            "    |           O\n" +
            "    |           |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "  __|________";
    private static final String PENDU_STATE_8 = "     _____________\n" +
            "    | /         |\n" +
            "    |/          |\n" +
            "    |           O\n" +
            "    |          /|  \n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            " ___|________";
    private static final String PENDU_STATE_9 = "     _____________\n" +
            "    | /         |\n" +
            "    |/          |\n" +
            "    |           O\n" +
            "    |          /|\\ \n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            " ___|________";
    private static final String PENDU_STATE_10 = "     _____________\n" +
            "    | /         |\n" +
            "    |/          |\n" +
            "    |           O\n" +
            "    |          /|\\ \n" +
            "    |          / \\ \n" +
            "    |\n" +
            "    |\n" +
            "  __|________";

    private DrawManager() {
    }

    /**
     * Get the good draw for a know number of fails
     *
     * @param nbLoose number of fails
     * @return current state of draw
     */
    public String getDrawForThisLooseNumber(int nbLoose) {
        switch (nbLoose) {
            case 1:
                return PENDU_STATE_1;
            case 2:
                return PENDU_STATE_2;
            case 3:
                return PENDU_STATE_3;
            case 4:
                return PENDU_STATE_4;
            case 5:
                return PENDU_STATE_5;
            case 6:
                return PENDU_STATE_6;
            case 7:
                return PENDU_STATE_7;
            case 8:
                return PENDU_STATE_8;
            case 9:
                return PENDU_STATE_9;
            case 10:
                return PENDU_STATE_10;
            default:
                return PENDU_STATE_0;
        }
    }
}
