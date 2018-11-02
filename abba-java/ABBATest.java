/*
import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

public class ABBATest {

    protected ABBA solution;

    @Before
    public void setUp() {
        solution = new ABBA();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String initial = "B";
        String target = "ABBA";

        String expected = "Possible";
        String actual = solution.canObtain(initial, target);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String initial = "AB";
        String target = "ABB";

        String expected = "Impossible";
        String actual = solution.canObtain(initial, target);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String initial = "BBAB";
        String target = "ABABABABB";

        String expected = "Impossible";
        String actual = solution.canObtain(initial, target);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String initial = "BBBBABABBBBBBA";
        String target = "BBBBABABBABBBBBBABABBBBBBBBABAABBBAA";

        String expected = "Possible";
        String actual = solution.canObtain(initial, target);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String initial = "A";
        String target = "BB";

        String expected = "Impossible";
        String actual = solution.canObtain(initial, target);

        Assert.assertEquals(expected, actual);
    }

}
*/