package utils.enums;

/**
 * Enum to manage difficulty.
 */
public enum EnumDifficulty {
    /**
     * EASY Mode.
     */
    EASY(1, 3, 4),
    /**
     * MEDIUM mode.
     */
    MEDIUM(2, 5, Integer.MAX_VALUE),
    /**
     * HARD mode.
     */
    HARD(3, 3, Integer.MAX_VALUE);

    /**
     * Difficulty value.
     */
    private int difficultyValue;
    /**
     * Min size of a word.
     */
    private int minSize;
    /**
     * MAx size of a word.
     */
    private int maxSize;

    /**
     * Constructor.
     *
     * @param difficultyValue int val of difficulty
     * @param minSize         min size of a word
     * @param maxSize         max size of a word
     */
    EnumDifficulty(int difficultyValue, int minSize, int maxSize) {
        this.difficultyValue = difficultyValue;
        this.minSize = minSize;
        this.maxSize = maxSize;
    }

    /**
     * Get the difficulty of the Game.
     *
     * @param value Enum Id Value
     * @return EnumDifficulty
     */
    public static EnumDifficulty getEnumByValue(int value) {
        EnumDifficulty result;
        switch (value) {
            case 1:
                result = EASY;
                break;
            case 2:
                result = MEDIUM;
                break;
            case 3:
                result = HARD;
                break;
            default:
                result = null;
                break;
        }
        return result;
    }

    /**
     * Get the Value of the difficulty.
     *
     * @return int
     */
    public int getDifficultyValue() {
        return difficultyValue;
    }

    /**
     * Get the minimum size.
     *
     * @return int
     */
    public int getMinSize() {
        return minSize;
    }

    /**
     * Get the maximum size.
     *
     * @return int
     */
    public int getMaxSize() {
        return maxSize;
    }
}
