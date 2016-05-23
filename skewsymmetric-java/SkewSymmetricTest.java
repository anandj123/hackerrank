import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SkewSymmetricTest {

    protected SkewSymmetric solution;

    @Before
    public void setUp() {
        solution = new SkewSymmetric();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] M = new String[]{"1 2 8", "-2 1 0", "3 99 3"};

        int expected = 5;
        int actual = solution.minChanges(M);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] M = new String[]{"0 1 1 1 1 1", "-1 0 1 1 1 1", "-1 -1 0 1 1 1", "-1 -1 -1 0 1 1", "-1 -1 -1 -1 0 1", "0 0 0 0 0 0"};

        int expected = 5;
        int actual = solution.minChanges(M);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] M = new String[]{"0 0 0 0", "0 0 0 0", "0 0 0 0", "0 0 0 0"};

        int expected = 0;
        int actual = solution.minChanges(M);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] M = new String[]{"1 0", "0 1"};

        int expected = 2;
        int actual = solution.minChanges(M);

        Assert.assertEquals(expected, actual);
    }

}
