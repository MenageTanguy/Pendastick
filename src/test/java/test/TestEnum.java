package test;

import org.junit.Assert;
import org.junit.Test;
import utils.enums.EnumDifficulty;

/**
 * Test class for enums
 */
public class TestEnum {

    /**
     * Check if enum difficulty are good
     */
    @Test
    public void testEnumDifficultyValue() {
        System.out.println("testEnumDifficultyValue EASY");
        Assert.assertEquals(EnumDifficulty.EASY.getDifficultyValue(), 1);
        Assert.assertEquals(EnumDifficulty.EASY.getMinSize(), 3);
        Assert.assertEquals(EnumDifficulty.EASY.getMaxSize(), 4);

        System.out.println("testEnumDifficultyValue MEDIUM");
        Assert.assertEquals(EnumDifficulty.MEDIUM.getDifficultyValue(), 2);
        Assert.assertEquals(EnumDifficulty.MEDIUM.getMinSize(), 5);
        Assert.assertEquals(EnumDifficulty.MEDIUM.getMaxSize(), Integer.MAX_VALUE);

        System.out.println("testEnumDifficultyValue getEnumByValue");
        Assert.assertEquals(EnumDifficulty.EASY, EnumDifficulty.getEnumByValue(1));
        Assert.assertEquals(EnumDifficulty.MEDIUM, EnumDifficulty.getEnumByValue(2));
        Assert.assertNull(EnumDifficulty.getEnumByValue(-54));
    }


}
