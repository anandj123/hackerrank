import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CompetitionStatisticsTest {

    protected CompetitionStatistics solution;

    @Before
    public void setUp() {
        solution = new CompetitionStatistics();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] ratingChanges = new int[]{30, 5, -5, 3, 3, 1};

        int expected = 3;
        int actual = solution.consecutiveGrowth(ratingChanges);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] ratingChanges = new int[]{-1, -5, -9};

        int expected = 0;
        int actual = solution.consecutiveGrowth(ratingChanges);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] ratingChanges = new int[]{12, 0, 15, 73};

        int expected = 2;
        int actual = solution.consecutiveGrowth(ratingChanges);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] ratingChanges = new int[]{12, 1, 15, 73};

        int expected = 4;
        int actual = solution.consecutiveGrowth(ratingChanges);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] ratingChanges = new int[]{-6, 13, 15, -11, 12, 12, 33, 12, -1};

        int expected = 4;
        int actual = solution.consecutiveGrowth(ratingChanges);

        Assert.assertEquals(expected, actual);
    }

}
