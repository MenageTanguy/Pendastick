package utils;

/**
 * Use this class manager to draw Pendu
 */
public class DrawManager {

    public static DrawManager instance = new DrawManager();


    public static final String PENDU_STATE_0 = "\n\n\n\n\n\n\n\n\n\n";
    public static final String PENDU_STATE_1 = "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "  __|________\n";
    public static final String PENDU_STATE_2 = "\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "  __|________";
    public static final String PENDU_STATE_3 = "     _____________\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "  __|________";
    public static final String PENDU_STATE_4 = "     _____________\n" +
            "    | / \n" +
            "    |/ \n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            " ___|________";
    public static final String PENDU_STATE_5 = "     _____________\n" +
            "    | /         |\n" +
            "    |/          |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "  __|________";
    public static final String PENDU_STATE_6 = "     _____________\n" +
            "    | /         |\n" +
            "    |/          |\n" +
            "    |           O\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "  __|________";
    public static final String PENDU_STATE_7 = "     _____________\n" +
            "    | /         |\n" +
            "    |/          |\n" +
            "    |           O\n" +
            "    |           |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "  __|________";
    public static final String PENDU_STATE_8 = "     _____________\n" +
            "    | /         |\n" +
            "    |/          |\n" +
            "    |           O\n" +
            "    |          /|  \n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            " ___|________";
    public static final String PENDU_STATE_9 = "     _____________\n" +
            "    | /         |\n" +
            "    |/          |\n" +
            "    |           O\n" +
            "    |          /|\\ \n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            " ___|________";
    public static final String PENDU_STATE_10 = "     _____________\n" +
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
        String result;
        switch (nbLoose) {
            case 1:
                result = PENDU_STATE_1;
                break;
            case 2:
                result = PENDU_STATE_2;
                break;
            case 3:
                result = PENDU_STATE_3;
                break;
            case 4:
                result = PENDU_STATE_4;
                break;
            case 5:
                result = PENDU_STATE_5;
                break;
            case 6:
                result = PENDU_STATE_6;
                break;
            case 7:
                result = PENDU_STATE_7;
                break;
            case 8:
                result = PENDU_STATE_8;
                break;
            case 9:
                result = PENDU_STATE_9;
                break;
            case 10:
                result = PENDU_STATE_10;
                break;
            default:
                result = PENDU_STATE_0;
                break;
        }
        return result;
    }
}
