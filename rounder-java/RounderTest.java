import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RounderTest {

    protected Rounder solution;

    @Before
    public void setUp() {
        solution = new Rounder();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int n = 5;
        int b = 10;

        int expected = 10;
        int actual = solution.round(n, b);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int n = 4;
        int b = 10;

        int expected = 0;
        int actual = solution.round(n, b);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int n = 100;
        int b = 3;

        int expected = 99;
        int actual = solution.round(n, b);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int n = 123456;
        int b = 7;

        int expected = 123459;
        int actual = solution.round(n, b);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int n = 49;
        int b = 7;

        int expected = 49;
        int actual = solution.round(n, b);

        Assert.assertEquals(expected, actual);
    }

}
