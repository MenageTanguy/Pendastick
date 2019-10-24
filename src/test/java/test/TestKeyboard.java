package test;


import org.junit.Assert;
import org.junit.Test;
import utils.KeyboardManager;

public class TestKeyboard extends TestUtils {
    @Test
    public void testReadCharacterKeyboard() {
        String readCharacter = KeyboardManager.instance.readCharacter(null);

    }
}
