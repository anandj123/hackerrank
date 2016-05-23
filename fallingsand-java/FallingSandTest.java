import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FallingSandTest {

    protected FallingSand solution;

    @Before
    public void setUp() {
        solution = new FallingSand();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] board = new String[]{"ooooo", "..x..", "....x", ".....", "....o"};

        String[] expected = new String[]{"..o..", "..x.o", "....x", ".....", "oo.oo"};
        String[] actual = solution.simulate(board);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] board = new String[]{"..o..", "..x.o", "....x", ".....", "oo.oo"};

        String[] expected = new String[]{"..o..", "..x.o", "....x", ".....", "oo.oo"};
        String[] actual = solution.simulate(board);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] board = new String[]{"ooooxooo.ooxo.oxoxoooox.....x.oo"};

        String[] expected = new String[]{"ooooxooo.ooxo.oxoxoooox.....x.oo"};
        String[] actual = solution.simulate(board);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] board = new String[]{"o", ".", "o", ".", "o", ".", "."};

        String[] expected = new String[]{".", ".", ".", ".", "o", "o", "o"};
        String[] actual = solution.simulate(board);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String[] board = new String[]{"oxxxxooo", "xooooxxx", "..xx.ooo", "oooox.o.", "..x....."};

        String[] expected = new String[]{"oxxxxooo", "x.oo.xxx", "..xxo...", ".oo.x.o.", "ooxo.ooo"};
        String[] actual = solution.simulate(board);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase5() {
        String[] board = new String[]{"..o..o..o..o..o..o..o..o..o..o..o", "o..o..o..o..o..o..o..o..o..o..o..", ".o..o..o..o..o..o..o..o..o..o..o.", "...xxx...xxx...xxxxxxxxx...xxx...", "...xxx...xxx...xxxxxxxxx...xxx...", "...xxx...xxx......xxx......xxx...", "...xxxxxxxxx......xxx......xxx...", "...xxxxxxxxx......xxx......xxx...", "...xxxxxxxxx......xxx......xxx...", "...xxx...xxx......xxx............", "...xxx...xxx...xxxxxxxxx...xxx...", "...xxx...xxx...xxxxxxxxx...xxx...", "..o..o..o..o..o..o..o..o..o..o..o", "o..o..o..o..o..o..o..o..o..o..o..", ".o..o..o..o..o..o..o..o..o..o..o."};

        String[] expected = new String[]{".................................", ".................................", "...ooo...ooo...ooooooooo...ooo...", "...xxx...xxx...xxxxxxxxx...xxx...", "...xxx...xxx...xxxxxxxxx...xxx...", "...xxxoooxxx......xxx......xxx...", "...xxxxxxxxx......xxx......xxx...", "...xxxxxxxxx......xxx......xxx...", "...xxxxxxxxx......xxx......xxx...", "...xxx...xxx......xxx............", "...xxx...xxx...xxxxxxxxx...xxx...", "...xxx...xxx...xxxxxxxxx...xxx...", ".................................", "ooo.........ooo.........ooo...ooo", "ooooooooooooooooooooooooooooooooo"};
        String[] actual = solution.simulate(board);

        Assert.assertArrayEquals(expected, actual);
    }

}
