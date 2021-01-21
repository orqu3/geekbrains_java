import org.junit.Assert;
import org.junit.Test;

public class TestSecondMethod {

    @Test
    public void test1() {
        Assert.assertTrue(Main.secondMethod(new int[]{1, 1, 1, 4, 4, 1, 4, 4}));
    }

    @Test
    public void test2() {
        Assert.assertFalse(Main.secondMethod(new int[]{1, 1, 1, 1, 1, 1,}));
    }

    @Test
    public void test3() {
        Assert.assertFalse(Main.secondMethod(new int[]{4, 4, 4, 4, 4}));
    }

    @Test
    public void test4() {
        Assert.assertFalse(Main.secondMethod(new int[]{1, 2, 1, 4, 4, 1, 3, 4}));
    }
}
