import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HexspeakTest {

    protected Hexspeak solution;

    @Before
    public void setUp() {
        solution = new Hexspeak();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        long ciphertext = 257L;

        String expected = "IOI";
        String actual = solution.decode(ciphertext);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        long ciphertext = 258L;

        String expected = "Error!";
        String actual = solution.decode(ciphertext);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        long ciphertext = 3405691582L;

        String expected = "CAFEBABE";
        String actual = solution.decode(ciphertext);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        long ciphertext = 2882400001L;

        String expected = "ABCDEFOI";
        String actual = solution.decode(ciphertext);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        long ciphertext = 999994830345994239L;

        String expected = "DEOBIFFFFFFFFFF";
        String actual = solution.decode(ciphertext);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase5() {
        long ciphertext = 1000000000000000000L;

        String expected = "Error!";
        String actual = solution.decode(ciphertext);

        Assert.assertEquals(expected, actual);
    }

}
