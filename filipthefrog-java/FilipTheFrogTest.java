import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FilipTheFrogTest {

    protected FilipTheFrog solution;

    @Before
    public void setUp() {
        solution = new FilipTheFrog();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] positions = new int[]{4, 7, 1, 3, 5};
        int L = 1;

        int expected = 3;
        int actual = solution.countReachableIslands(positions, L);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] positions = new int[]{100, 101, 103, 105, 107};
        int L = 2;

        int expected = 5;
        int actual = solution.countReachableIslands(positions, L);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] positions = new int[]{17, 10, 22, 14, 6, 1, 2, 3};
        int L = 4;

        int expected = 7;
        int actual = solution.countReachableIslands(positions, L);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] positions = new int[]{0};
        int L = 1000;

        int expected = 1;
        int actual = solution.countReachableIslands(positions, L);

        Assert.assertEquals(expected, actual);
    }

}
