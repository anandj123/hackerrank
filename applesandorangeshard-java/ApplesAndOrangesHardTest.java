import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ApplesAndOrangesHardTest {

    protected ApplesAndOrangesHard solution;

    @Before
    public void setUp() {
        solution = new ApplesAndOrangesHard();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int N = 3;
        int K = 2;
        int[] info = new int[]{};

        int expected = 2;
        int actual = solution.maximumApples(N, K, info);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int N = 10;
        int K = 3;
        int[] info = new int[]{3, 8};

        int expected = 2;
        int actual = solution.maximumApples(N, K, info);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int N = 9;
        int K = 4;
        int[] info = new int[]{1, 4};

        int expected = 5;
        int actual = solution.maximumApples(N, K, info);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int N = 9;
        int K = 4;
        int[] info = new int[]{2, 4};

        int expected = 4;
        int actual = solution.maximumApples(N, K, info);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int N = 23;
        int K = 7;
        int[] info = new int[]{3, 2, 9, 1, 15, 23, 20, 19};

        int expected = 10;
        int actual = solution.maximumApples(N, K, info);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 25000)
    public void testCase5() {
        int N = 1000000000;
        int K = 17;
        int[] info = new int[]{2110119, 401933834, 401933833, 10};

        int expected = 470588238;
        int actual = solution.maximumApples(N, K, info);

        Assert.assertEquals(expected, actual);
    }

}
