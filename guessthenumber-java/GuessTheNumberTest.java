import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GuessTheNumberTest {

    protected GuessTheNumber solution;

    @Before
    public void setUp() {
        solution = new GuessTheNumber();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int upper = 9;
        int answer = 6;

        int expected = 3;
        int actual = solution.noGuesses(upper, answer);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int upper = 1000;
        int answer = 750;

        int expected = 2;
        int actual = solution.noGuesses(upper, answer);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int upper = 643;
        int answer = 327;

        int expected = 7;
        int actual = solution.noGuesses(upper, answer);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int upper = 157;
        int answer = 157;

        int expected = 8;
        int actual = solution.noGuesses(upper, answer);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int upper = 128;
        int answer = 64;

        int expected = 1;
        int actual = solution.noGuesses(upper, answer);

        Assert.assertEquals(expected, actual);
    }

}
