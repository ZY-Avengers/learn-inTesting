package github.meifans.inTesting.JUC;

import org.junit.Test;

import java.util.logging.Logger;

/**
 * Created by Meifans Zhao on 2017/4/11.
 */

public class ReentrantLockScenario {
    private int count ;
    private long countlong;

    public void incrementing(int i){
        count ++;
        countlong =countlong+ count + i;
    }


    public static class ReentrantLockTest{
        private static final Logger log = Logger.getLogger(ReentrantLockTest.class.getName());
        ReentrantLockScenario scenario = new ReentrantLockScenario();
        @Test
        public void use() throws InterruptedException {

            for(int i = 0;i < 1000;i++) {
                final int j=i;
                Thread thread = new Thread(() -> {
                    Thread.yield();
                    scenario.incrementing(j);
                });
                thread.start();
            }
            Thread.sleep(2000);
           log.info(""+scenario.count+"and"+scenario.countlong);
        }
    }
}
