import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ContainersTest {

    protected Containers solution;

    @Before
    public void setUp() {
        solution = new Containers();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] containers = new int[]{5, 5, 5};
        int[] packages = new int[]{5, 5, 5};

        int expected = 0;
        int actual = solution.wastedSpace(containers, packages);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] containers = new int[]{5, 6, 7};
        int[] packages = new int[]{5, 5, 5};

        int expected = 3;
        int actual = solution.wastedSpace(containers, packages);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] containers = new int[]{2, 3, 5};
        int[] packages = new int[]{3};

        int expected = 7;
        int actual = solution.wastedSpace(containers, packages);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] containers = new int[]{3, 4, 5, 6};
        int[] packages = new int[]{3, 3, 3, 3, 3};

        int expected = 3;
        int actual = solution.wastedSpace(containers, packages);

        Assert.assertEquals(expected, actual);
    }

}
