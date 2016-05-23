import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JustifyTextTest {

    protected JustifyText solution;

    @Before
    public void setUp() {
        solution = new JustifyText();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] text = new String[]{"BOB", "TOMMY", "JIM"};

        String[] expected = new String[]{"  BOB", "TOMMY", "  JIM"};
        String[] actual = solution.format(text);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] text = new String[]{"JOHN", "JAKE", "ALAN", "BLUE"};

        String[] expected = new String[]{"JOHN", "JAKE", "ALAN", "BLUE"};
        String[] actual = solution.format(text);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] text = new String[]{"LONGEST", "A", "LONGER", "SHORT"};

        String[] expected = new String[]{"LONGEST", "      A", " LONGER", "  SHORT"};
        String[] actual = solution.format(text);

        Assert.assertArrayEquals(expected, actual);
    }

}
