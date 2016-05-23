import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChessFloorTest {

    protected ChessFloor solution;

    @Before
    public void setUp() {
        solution = new ChessFloor();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] floor = new String[]{"aba", "bbb", "aba"};

        int expected = 1;
        int actual = solution.minimumChanges(floor);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] floor = new String[]{"wbwbwbwb", "bwbwbwbw", "wbwbwbwb", "bwbwbwbw", "wbwbwbwb", "bwbwbwbw", "wbwbwbwb", "bwbwbwbw"};

        int expected = 0;
        int actual = solution.minimumChanges(floor);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] floor = new String[]{"zz", "zz"};

        int expected = 2;
        int actual = solution.minimumChanges(floor);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] floor = new String[]{"helloand", "welcomet", "osingler", "oundmatc", "hsixhund", "redandsi", "xtythree", "goodluck"};

        int expected = 56;
        int actual = solution.minimumChanges(floor);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String[] floor = new String[]{"jecjxsengslsmeijrmcx", "tcfyhumjcvgkafhhffed", "icmgxrlalmhnwwdhqerc", "xzrhzbgjgabanfxgabed", "fpcooilmwqixfagfojjq", "xzrzztidmchxrvrsszii", "swnwnrchxujxsknuqdkg", "rnvzvcxrukeidojlakcy", "kbagitjdrxawtnykrivw", "towgkjctgelhpomvywyb", "ucgqrhqntqvncargnhhv", "mhvwsgvfqgfxktzobetn", "fabxcmzbbyblxxmjcaib", "wpiwnrdqdixharhjeqwt", "xfgulejzvfgvkkuyngdn", "kedsalkounuaudmyqggb", "gvleogefcsxfkyiraabn", "tssjsmhzozbcsqqbebqw", "ksbfjoirwlmnoyyqpbvm", "phzsdodppzfjjmzocnge"};

        int expected = 376;
        int actual = solution.minimumChanges(floor);

        Assert.assertEquals(expected, actual);
    }

}
