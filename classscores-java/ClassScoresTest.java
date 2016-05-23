import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClassScoresTest {

    protected ClassScores solution;

    @Before
    public void setUp() {
        solution = new ClassScores();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] scores = new int[]{65, 70, 88, 70};

        int[] expected = new int[]{70};
        int[] actual = solution.findMode(scores);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] scores = new int[]{88, 70, 65, 70, 88};

        int[] expected = new int[]{70, 88};
        int[] actual = solution.findMode(scores);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] scores = new int[]{92, 56, 14, 73, 22, 38, 93, 45, 55};

        int[] expected = new int[]{14, 22, 38, 45, 55, 56, 73, 92, 93};
        int[] actual = solution.findMode(scores);

        Assert.assertArrayEquals(expected, actual);
    }

}
