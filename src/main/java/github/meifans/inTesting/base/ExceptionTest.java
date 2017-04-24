package github.meifans.inTesting.base;

import lombok.extern.java.Log;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Meifans Zhao on 2017/4/24.
 */
@Log
public class ExceptionTest {

    @Test
    public void testFinal() {
        Data heng = heng();
        Assert.assertEquals(1, heng.anInt);
    }

    private Data heng() {
        Data data = new Data();
        try {
            data.anInt = 1;
            return data;
        } catch (Exception e) {
        } finally {
            data.anInt = 2;
        }
        return null;
    }

    class Data {
        int anInt;

    }

}
