import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KitayutaMart2Test {

    protected KitayutaMart2 solution;

    @Before
    public void setUp() {
        solution = new KitayutaMart2();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int K = 100;
        int T = 100;

        int expected = 1;
        int actual = solution.numBought(K, T);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int K = 100;
        int T = 300;

        int expected = 2;
        int actual = solution.numBought(K, T);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int K = 150;
        int T = 1050;

        int expected = 3;
        int actual = solution.numBought(K, T);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int K = 160;
        int T = 163680;

        int expected = 10;
        int actual = solution.numBought(K, T);

        Assert.assertEquals(expected, actual);
    }

}
