import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RobotOnMoonEasyTest {

    protected RobotOnMoonEasy solution;

    @Before
    public void setUp() {
        solution = new RobotOnMoonEasy();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] board = new String[]{".....", ".###.", "..S#.", "...#."};
        String S = "URURURURUR";

        String expected = "Alive";
        String actual = solution.isSafeCommand(board, S);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] board = new String[]{".....", ".###.", "..S..", "...#."};
        String S = "URURURURUR";

        String expected = "Dead";
        String actual = solution.isSafeCommand(board, S);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] board = new String[]{".....", ".###.", "..S..", "...#."};
        String S = "URURU";

        String expected = "Alive";
        String actual = solution.isSafeCommand(board, S);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] board = new String[]{"#####", "#...#", "#.S.#", "#...#", "#####"};
        String S = "DRULURLDRULRUDLRULDLRULDRLURLUUUURRRRDDLLDD";

        String expected = "Alive";
        String actual = solution.isSafeCommand(board, S);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String[] board = new String[]{"#####", "#...#", "#.S.#", "#...#", "#.###"};
        String S = "DRULURLDRULRUDLRULDLRULDRLURLUUUURRRRDDLLDD";

        String expected = "Dead";
        String actual = solution.isSafeCommand(board, S);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase5() {
        String[] board = new String[]{"S"};
        String S = "R";

        String expected = "Dead";
        String actual = solution.isSafeCommand(board, S);

        Assert.assertEquals(expected, actual);
    }

}
