import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Fragile2Test {

    protected Fragile2 solution;

    @Before
    public void setUp() {
        solution = new Fragile2();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] graph = new String[]{"NYNN", "YNYN", "NYNY", "NNYN"};

        int expected = 3;
        int actual = solution.countPairs(graph);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] graph = new String[]{"NYNNNN", "YNYNNN", "NYNNNN", "NNNNYN", "NNNYNY", "NNNNYN"};

        int expected = 5;
        int actual = solution.countPairs(graph);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] graph = new String[]{"NNN", "NNN", "NNN"};

        int expected = 0;
        int actual = solution.countPairs(graph);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] graph = new String[]{"NYNYNNYYNN", "YNNNYNYYNN", "NNNNYNNNYN", "YNNNYYNNNN", "NYYYNNNNYN", "NNNYNNNNYN", "YYNNNNNNNN", "YYNNNNNNYN", "NNYNYYNYNY", "NNNNNNNNYN"};

        int expected = 9;
        int actual = solution.countPairs(graph);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String[] graph = new String[]{"NNNYNNYNNNNNNNYYNNNY", "NNNNNNNNYNNNNNNNNNNN", "NNNNNNNNNNNNNNNNNNNN", "YNNNNNNNNNYNNNNNNNNN", "NNNNNNNYNNNNNYNNNNYN", "NNNNNNNNNNNNNNNNYNNY", "YNNNNNNNNNNNNYYYNYNN", "NNNNYNNNNNNNNYYNNNNN", "NYNNNNNNNYNNNNNNNNNN", "NNNNNNNNYNNNYNNNNNYN", "NNNYNNNNNNNNNNYNNNNN", "NNNNNNNNNNNNNNNNNNNN", "NNNNNNNNNYNNNNNNNYNN", "NNNNYNYYNNNNNNNNNNNN", "YNNNNNYYNNYNNNNNNNNN", "YNNNNNYNNNNNNNNNYNNN", "NNNNNYNNNNNNNNNYNYNN", "NNNNNNYNNNNNYNNNYNNN", "NNNNYNNNNYNNNNNNNNNN", "YNNNNYNNNNNNNNNNNNNN"};

        int expected = 42;
        int actual = solution.countPairs(graph);

        Assert.assertEquals(expected, actual);
    }

}
