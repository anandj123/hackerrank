import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LCMRangeTest {

    protected LCMRange solution;

    @Before
    public void setUp() {
        solution = new LCMRange();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int first = 1;
        int last = 5;

        int expected = 60;
        int actual = solution.lcm(first, last);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int first = 4;
        int last = 5;

        int expected = 20;
        int actual = solution.lcm(first, last);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int first = 1;
        int last = 12;

        int expected = 27720;
        int actual = solution.lcm(first, last);

        Assert.assertEquals(expected, actual);
    }

}
