import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CuttingPolesTest {

    protected CuttingPoles solution;

    @Before
    public void setUp() {
        solution = new CuttingPoles();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] poles = new int[]{1, 3};

        int expected = 1;
        int actual = solution.countCuts(poles);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] poles = new int[]{10, 10, 10};

        int expected = 0;
        int actual = solution.countCuts(poles);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] poles = new int[]{1, 1, 3, 3};

        int expected = 2;
        int actual = solution.countCuts(poles);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] poles = new int[]{10, 10, 10, 10, 10, 10, 10, 18};

        int expected = 7;
        int actual = solution.countCuts(poles);

        Assert.assertEquals(expected, actual);
    }

}
