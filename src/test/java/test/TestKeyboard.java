package test;

import org.junit.Ignore;
import org.junit.Test;
import utils.KeyboardManager;

/**
 * Test Keyboard using System.in
 */
public class TestKeyboard extends TestUtils {

    /**
     * Test read keyboard input
     */
    @Test
    @Ignore
    public void testReadCharacterKeyboard() {
        String readCharacter = KeyboardManager.instance.readCharacter(null);

    }
}
