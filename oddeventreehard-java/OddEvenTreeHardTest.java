import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OddEvenTreeHardTest {

    protected OddEvenTreeHard solution;

    @Before
    public void setUp() {
        solution = new OddEvenTreeHard();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] x = new String[]{"EOE", "OEO", "EOE"};

        int[] expected = new int[]{0, 1, 2, 1};
        int[] actual = solution.getTree(x);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] x = new String[]{"????", "????", "????", "????"};

        int[] expected = new int[]{0, 1, 0, 3, 2, 1};
        int[] actual = solution.getTree(x);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] x = new String[]{"????", "????", "??O?", "????"};

        int[] expected = new int[]{-1};
        int[] actual = solution.getTree(x);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] x = new String[]{"??O?", "????", "E???", "????"};

        int[] expected = new int[]{-1};
        int[] actual = solution.getTree(x);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String[] x = new String[]{"?O??", "??O?", "???O", "????"};

        int[] expected = new int[]{0, 1, 0, 3, 2, 1};
        int[] actual = solution.getTree(x);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase5() {
        String[] x = new String[]{"?E??", "??E?", "???E", "????"};

        int[] expected = new int[]{-1};
        int[] actual = solution.getTree(x);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase6() {
        String[] x = new String[]{"?????????????", "??????????OE?", "?????????????", "?????????????", "?????????????", "?????????????", "?????????????", "???????E?????", "???????E?????", "?????????????", "???????????O?", "???????????E?", "????????????E"};

        int[] expected = new int[]{0, 1, 0, 3, 0, 5, 0, 7, 0, 8, 0, 11, 0, 12, 2, 1, 4, 1, 6, 1, 9, 1, 10, 1};
        int[] actual = solution.getTree(x);

        Assert.assertArrayEquals(expected, actual);
    }

}
