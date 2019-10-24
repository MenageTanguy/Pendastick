package utils.enums;

/**
 * Enum to manage difficulty
 */
public enum EnumDifficulty {
    /**
     * EASY Mode
     */
    EASY(1, 3, 5),
    /**
     * MEDIUM mode
     */
    MEDIUM(2, 5, Integer.MAX_VALUE);

    /**
     * Difficulty value
     */
    private int difficultyValue;
    /**
     * Min size of a word
     */
    private int minSize;
    /**
     * MAx size of a word
     */
    private int maxSize;

    /**
     * Constructor
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

    public static EnumDifficulty getEnumByValue(int value) {
        EnumDifficulty result = null;
        switch (value) {
            case 1:
                result = EASY;
                break;
            case 2:
                result = MEDIUM;
                break;
        }
        return result;
    }

    public int getDifficultyValue() {
        return difficultyValue;
    }

    public int getMinSize() {
        return minSize;
    }

    public int getMaxSize() {
        return maxSize;
    }
}
