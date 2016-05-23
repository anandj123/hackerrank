import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DiskSpaceTest {

    protected DiskSpace solution;

    @Before
    public void setUp() {
        solution = new DiskSpace();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] used = new int[]{300, 525, 110};
        int[] total = new int[]{350, 600, 115};

        int expected = 2;
        int actual = solution.minDrives(used, total);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] used = new int[]{1, 200, 200, 199, 200, 200};
        int[] total = new int[]{1000, 200, 200, 200, 200, 200};

        int expected = 1;
        int actual = solution.minDrives(used, total);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] used = new int[]{750, 800, 850, 900, 950};
        int[] total = new int[]{800, 850, 900, 950, 1000};

        int expected = 5;
        int actual = solution.minDrives(used, total);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] used = new int[]{49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49};
        int[] total = new int[]{50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50};

        int expected = 49;
        int actual = solution.minDrives(used, total);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] used = new int[]{331, 242, 384, 366, 428, 114, 145, 89, 381, 170, 329, 190, 482, 246, 2, 38, 220, 290, 402, 385};
        int[] total = new int[]{992, 509, 997, 946, 976, 873, 771, 565, 693, 714, 755, 878, 897, 789, 969, 727, 765, 521, 961, 906};

        int expected = 6;
        int actual = solution.minDrives(used, total);

        Assert.assertEquals(expected, actual);
    }

}
