package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pendu.Application;
import pendu.Pendu;
import utils.KeyboardManager;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class TestApplication extends TestUtils {

    private final InputStream originalOut = System.in;

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
        System.setIn(this.originalOut);
    }

    @Test
    public void testApplicationAndKeyboard() {
        enter("a\nb\ntest\ni\n1\nj\n \no\n" + "5\n5\n2\ni\n1\n"
                + PATH_TO_FILE_TEST + "\ngdihoshodè''è.fiid\n" + PATH_TO_FILE_TEST + "\n"
                + "Y\n1\n1\nz\nz\nz\nz\nz\nz\nz\nz\nz\nz\nz\nz\nz\nz\nw\nw\nw\nw\nw\nw\nw\nw\nw\nw\nw\nw\nw\nw\nN\n"
                + "Y\n2\n" + PATH_ONE_WORD + "\n1\np\na\nr\nN\n");
        System.out.println("Test readCharacter");
        Assert.assertEquals("a", KeyboardManager.instance.readCharacter("test keyboard a"));
        Assert.assertEquals("b", KeyboardManager.instance.readCharacter("test keyboard b"));
        Assert.assertEquals("i", KeyboardManager.instance.readCharacter("test keyboard no read test, read i"));
        Assert.assertEquals("j", KeyboardManager.instance.readCharacter("test keyboard no read 1, read j"));
        Assert.assertEquals("o", KeyboardManager.instance.readCharacter("test keyboard no read \" \", read o"));

        System.out.println("Test readNumber");
        Assert.assertEquals(5, KeyboardManager.instance.readNumber("test read number 5 border 2 6", 2, 6));
        Assert.assertEquals(2, KeyboardManager.instance.readNumber("test read number 5 border 1 3 NO 2 works", 1, 3));
        Assert.assertEquals(1, KeyboardManager.instance.readNumber("test read char i border 0 5 NO 1 works", 0, 5));

        System.out.println("Test readPath");
        Assert.assertEquals(PATH_TO_FILE_TEST, KeyboardManager.instance.readPath("test read path good input"));
        Assert.assertEquals(PATH_TO_FILE_TEST, KeyboardManager.instance.readPath("test read path 1st input wrong"));

        System.out.println("Test isSame");
        Assert.assertTrue(KeyboardManager.instance.isSame("TEST", "TEST"));
        Assert.assertFalse(KeyboardManager.instance.isSame("TEST", "toto"));
        Assert.assertTrue(KeyboardManager.instance.isSame("TEST", "test"));

        System.out.println("Test Application bad word");
        Application app = new Application();
        app.startPlaying();
        Assert.assertFalse(Pendu.instance.isWordIsFind());

        System.out.println("Test Application good word");
        app = new Application();
        app.startPlaying();
        Assert.assertTrue(Pendu.instance.isWordIsFind());

    }


    /**
     * Check if the value of string is in keyboard test list
     *
     * @param value input value
     */
    private void enter(String value) {
        try {
            Thread.sleep(500);
            final ByteArrayInputStream inContent = new ByteArrayInputStream(value.getBytes());
            System.setIn(inContent);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
