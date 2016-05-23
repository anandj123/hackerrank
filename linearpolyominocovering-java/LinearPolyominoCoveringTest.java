import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinearPolyominoCoveringTest {

    protected LinearPolyominoCovering solution;

    @Before
    public void setUp() {
        solution = new LinearPolyominoCovering();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String region = "XXXXXX";

        String expected = "AAAABB";
        String actual = solution.findCovering(region);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String region = "XX.XX";

        String expected = "BB.BB";
        String actual = solution.findCovering(region);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String region = "XXXX....XXX.....XX";

        String expected = "impossible";
        String actual = solution.findCovering(region);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String region = "X";

        String expected = "impossible";
        String actual = solution.findCovering(region);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String region = "XX.XXXXXXXXXX..XXXXXXXX...XXXXXX";

        String expected = "BB.AAAAAAAABB..AAAAAAAA...AAAABB";
        String actual = solution.findCovering(region);

        Assert.assertEquals(expected, actual);
    }

}
