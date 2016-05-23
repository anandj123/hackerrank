import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MutaliskEasyTest {

    protected MutaliskEasy solution;

    @Before
    public void setUp() {
        solution = new MutaliskEasy();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] x = new int[]{12, 10, 4};

        int expected = 2;
        int actual = solution.minimalAttacks(x);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] x = new int[]{54, 18, 6};

        int expected = 6;
        int actual = solution.minimalAttacks(x);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 50000)
    public void testCase2() {
        int[] x = new int[]{55, 60, 53};

        int expected = 13;
        int actual = solution.minimalAttacks(x);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] x = new int[]{1, 1, 1};

        int expected = 1;
        int actual = solution.minimalAttacks(x);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 25000)
    public void testCase4() {
        int[] x = new int[]{60, 40};

        int expected = 9;
        int actual = solution.minimalAttacks(x);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 25000)
    public void testCase5() {
        int[] x = new int[]{60};

        int expected = 7;
        int actual = solution.minimalAttacks(x);

        Assert.assertEquals(expected, actual);
    }

}
