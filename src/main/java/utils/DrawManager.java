package utils;

/**
 * Use this class manager to draw Pendu
 */
public class DrawManager {

    private static final String TOP_BAR = "     _____________\n";
    private static final String COLUMN = "    |\n";
    private static final String BASE = "  __|________";

    public static final String PENDU_STATE_0 = "\n\n\n\n\n\n\n\n\n\n";
    public static final String PENDU_STATE_1 = "\n\n\n\n\n\n\n\n\n"
            + "  ___|________\n";
    public static final String PENDU_STATE_2 = "\n"
            + COLUMN
            + COLUMN
            + COLUMN
            + COLUMN
            + COLUMN
            + COLUMN
            + COLUMN
            + BASE;
    public static final String PENDU_STATE_3 = TOP_BAR
            + COLUMN
            + COLUMN
            + COLUMN
            + COLUMN
            + COLUMN
            + COLUMN
            + COLUMN
            + BASE;
    public static final String PENDU_STATE_4 = TOP_BAR
            + "    | / \n"
            + "    |/ \n"
            + COLUMN
            + COLUMN
            + COLUMN
            + COLUMN
            + COLUMN
            + BASE;
    public static final String PENDU_STATE_5 = TOP_BAR
            + "    | /         |\n"
            + "    |/          |\n"
            + COLUMN
            + COLUMN
            + COLUMN
            + COLUMN
            + COLUMN
            + BASE;
    public static final String PENDU_STATE_6 = TOP_BAR
            + "    | /         |\n"
            + "    |/          |\n"
            + "    |           O\n"
            + COLUMN
            + COLUMN
            + COLUMN
            + COLUMN
            + BASE;
    public static final String PENDU_STATE_7 = TOP_BAR
            + "    | /         |\n"
            + "    |/          |\n"
            + "    |           O\n"
            + "    |           |\n"
            + COLUMN
            + COLUMN
            + COLUMN
            + BASE;
    public static final String PENDU_STATE_8 = TOP_BAR
            + "    | /         |\n"
            + "    |/          |\n"
            + "    |           O\n"
            + "    |          /|  \n"
            + COLUMN
            + COLUMN
            + COLUMN
            + BASE;
    public static final String PENDU_STATE_9 = TOP_BAR
            + "    | /         |\n"
            + "    |/          |\n"
            + "    |           O\n"
            + "    |          /|\\ \n"
            + COLUMN
            + COLUMN
            + COLUMN
            + BASE;
    public static final String PENDU_STATE_10 = TOP_BAR
            + "    | /         |\n"
            + "    |/          |\n"
            + "    |           O\n"
            + "    |          /|\\ \n"
            + "    |          / \\ \n"
            + COLUMN
            + COLUMN
            + BASE;

    public static DrawManager instance = new DrawManager();

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
