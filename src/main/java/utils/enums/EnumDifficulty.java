package utils.enums;

public enum EnumDifficulty {

    EASY(1, 3, 5), MEDIUM(2, 5, Integer.MAX_VALUE);

    private int difficultyValue;
    private int minSize;
    private int maxSize;

    EnumDifficulty(int difficultyValue, int minSize, int maxSize) {
        this.difficultyValue = difficultyValue;
        this.minSize = minSize;
        this.maxSize = maxSize;
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
