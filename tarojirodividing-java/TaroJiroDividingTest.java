import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TaroJiroDividingTest {

    protected TaroJiroDividing solution;

    @Before
    public void setUp() {
        solution = new TaroJiroDividing();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int A = 8;
        int B = 4;

        int expected = 3;
        int actual = solution.getNumber(A, B);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int A = 4;
        int B = 7;

        int expected = 0;
        int actual = solution.getNumber(A, B);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int A = 12;
        int B = 12;

        int expected = 3;
        int actual = solution.getNumber(A, B);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int A = 24;
        int B = 96;

        int expected = 4;
        int actual = solution.getNumber(A, B);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int A = 1000000000;
        int B = 999999999;

        int expected = 0;
        int actual = solution.getNumber(A, B);

        Assert.assertEquals(expected, actual);
    }

}
