import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InfiniteStringTest {

    protected InfiniteString solution;

    @Before
    public void setUp() {
        solution = new InfiniteString();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String s = "ab";
        String t = "abab";

        String expected = "Equal";
        String actual = solution.equal(s, t);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String s = "abc";
        String t = "bca";

        String expected = "Not equal";
        String actual = solution.equal(s, t);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String s = "abab";
        String t = "aba";

        String expected = "Not equal";
        String actual = solution.equal(s, t);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String s = "aaaaa";
        String t = "aaaaaa";

        String expected = "Equal";
        String actual = solution.equal(s, t);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String s = "ababab";
        String t = "abab";

        String expected = "Equal";
        String actual = solution.equal(s, t);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase5() {
        String s = "a";
        String t = "z";

        String expected = "Not equal";
        String actual = solution.equal(s, t);

        Assert.assertEquals(expected, actual);
    }

}
