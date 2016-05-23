import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PublicTransitTest {

    protected PublicTransit solution;

    @Before
    public void setUp() {
        solution = new PublicTransit();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int R = 4;
        int C = 1;

        int expected = 1;
        int actual = solution.minimumLongestDistance(R, C);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int R = 2;
        int C = 2;

        int expected = 1;
        int actual = solution.minimumLongestDistance(R, C);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int R = 5;
        int C = 3;

        int expected = 4;
        int actual = solution.minimumLongestDistance(R, C);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int R = 8;
        int C = 2;

        int expected = 4;
        int actual = solution.minimumLongestDistance(R, C);

        Assert.assertEquals(expected, actual);
    }

}
