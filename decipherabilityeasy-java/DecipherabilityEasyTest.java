import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DecipherabilityEasyTest {

    protected DecipherabilityEasy solution;

    @Before
    public void setUp() {
        solution = new DecipherabilityEasy();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String s = "sunuke";
        String t = "snuke";

        String expected = "Possible";
        String actual = solution.check(s, t);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String s = "snuke";
        String t = "skue";

        String expected = "Impossible";
        String actual = solution.check(s, t);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String s = "snuke";
        String t = "snuke";

        String expected = "Impossible";
        String actual = solution.check(s, t);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String s = "snukent";
        String t = "snuke";

        String expected = "Impossible";
        String actual = solution.check(s, t);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String s = "aaaaa";
        String t = "aaaa";

        String expected = "Possible";
        String actual = solution.check(s, t);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase5() {
        String s = "aaaaa";
        String t = "aaa";

        String expected = "Impossible";
        String actual = solution.check(s, t);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase6() {
        String s = "topcoder";
        String t = "tpcoder";

        String expected = "Possible";
        String actual = solution.check(s, t);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase7() {
        String s = "singleroundmatch";
        String t = "singeroundmatc";

        String expected = "Impossible";
        String actual = solution.check(s, t);

        Assert.assertEquals(expected, actual);
    }

}
