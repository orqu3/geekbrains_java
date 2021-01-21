import org.junit.Assert;
import org.junit.Test;

public class TestFirstMethod {

    @Test
    public void test1() {
        Assert.assertArrayEquals(new int[]{1, 7},
                Main.firstMethod(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}));
    }

    @Test
    public void test2() {
        Assert.assertArrayEquals(new int[]{2, 5, 9, 2, 3, 1},
                Main.firstMethod(new int[]{4, 2, 5, 9, 2, 3, 1}));

    }

    @Test
    public void test3() {
        Assert.assertArrayEquals(new int[]{},
                Main.firstMethod(new int[]{1, 2, 3, 9, 2, 3, 8, 1, 4}));
    }

    @Test(expected = RuntimeException.class)
    public void test4() {
        Main.firstMethod(new int[]{1, 2, 7, 8, 2, 3, 9, 1, 7});
    }
}
