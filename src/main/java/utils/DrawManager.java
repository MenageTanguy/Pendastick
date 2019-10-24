package utils;

/**
 * Use this class manager to draw Pendu.
 */
public class DrawManager {

    private static final String TOP_BAR = "     _____________\n";
    private static final String SECOND_BAR = "    | /         |\n";
    private static final String THIRD_BAR = "    |/          |\n";
    private static final String HEAD = "    |           O\n";
    private static final String COLUMN = "    |\n";
    private static final String BASE = "  __|________";

    /**
     *  State 0 of the Hangman.
     */
    public static final String PENDU_STATE_0 = "\n\n\n\n\n\n\n\n\n\n";

    /**
     *  State 1 of the Hangman.
     */
    public static final String PENDU_STATE_1 = "\n\n\n\n\n\n\n\n\n"
            + "  ___|________\n";

    /**
     *  State 2 of the Hangman.
     */
    public static final String PENDU_STATE_2 = "\n"
            + COLUMN
            + COLUMN
            + COLUMN
            + COLUMN
            + COLUMN
            + COLUMN
            + COLUMN
            + BASE;

    /**
     *  State 3 of the Hangman.
     */
    public static final String PENDU_STATE_3 = TOP_BAR
            + COLUMN
            + COLUMN
            + COLUMN
            + COLUMN
            + COLUMN
            + COLUMN
            + COLUMN
            + BASE;

    /**
     *  State 4 of the Hangman.
     */
    public static final String PENDU_STATE_4 = TOP_BAR
            + "    | / \n"
            + "    |/ \n"
            + COLUMN
            + COLUMN
            + COLUMN
            + COLUMN
            + COLUMN
            + BASE;

    /**
     *  State 5 of the Hangman.
     */
    public static final String PENDU_STATE_5 = TOP_BAR
            + SECOND_BAR
            + THIRD_BAR
            + COLUMN
            + COLUMN
            + COLUMN
            + COLUMN
            + COLUMN
            + BASE;

    /**
     *  State 6 of the Hangman.
     */
    public static final String PENDU_STATE_6 = TOP_BAR
            + SECOND_BAR
            + THIRD_BAR
            + HEAD
            + COLUMN
            + COLUMN
            + COLUMN
            + COLUMN
            + BASE;

    /**
     *  State 7 of the Hangman.
     */
    public static final String PENDU_STATE_7 = TOP_BAR
            + SECOND_BAR
            + THIRD_BAR
            + HEAD
            + "    |           |\n"
            + COLUMN
            + COLUMN
            + COLUMN
            + BASE;

    /**
     *  State 8 of the Hangman.
     */
    public static final String PENDU_STATE_8 = TOP_BAR
            + SECOND_BAR
            + THIRD_BAR
            + HEAD
            + "    |          /|  \n"
            + COLUMN
            + COLUMN
            + COLUMN
            + BASE;

    /**
     *  State 9 of the Hangman.
     */
    public static final String PENDU_STATE_9 = TOP_BAR
            + SECOND_BAR
            + THIRD_BAR
            + HEAD
            + "    |          /|\\ \n"
            + COLUMN
            + COLUMN
            + COLUMN
            + BASE;

    /**
     *  State 10 of the Hangman.
     */
    public static final String PENDU_STATE_10 = TOP_BAR
            + SECOND_BAR
            + THIRD_BAR
            + HEAD
            + "    |          /|\\ \n"
            + "    |          / \\ \n"
            + COLUMN
            + COLUMN
            + BASE;

    /**
     *  Instance of the DrawManage Class.
     */
    public static DrawManager instance = new DrawManager();

    private DrawManager() {
    }

    /**
     * Get the good draw for a know number of fails.
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
