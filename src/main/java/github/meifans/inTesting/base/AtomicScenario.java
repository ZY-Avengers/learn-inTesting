package github.meifans.inTesting.base;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author pengfei.zhao
 */
public class AtomicScenario {

    private static final AtomicInteger ATOMIC_INTEGER = new AtomicInteger(0);

    @Test
    public void test() {
        for (int i = 0; i < 10; i++) {
            System.out.println(ATOMIC_INTEGER.getAndIncrement() % 2);
        }
    }

}
