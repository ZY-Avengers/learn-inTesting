package github.meifans.inTesting.JUC;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.extern.java.Log;
import org.junit.Test;

/**
 * Created by Meifans on 17/4/25.
 */
@Log
public class VolatileScenario {

  volatile static boolean shutDown =true;

  volatile static int count =0;

  volatile static int[] a = {1,2,3};

  static void work(){
    while (shutDown == true)
      log.info("work is something never end");
  }

  static synchronized void write(){
    count++; //not atom operation,so use sync prevent mutli-thread concurrent write.
  }
  static int read(){
    return count;
  }


  @Log
  public static class VolatileTest{


    @Test
    public void asStatus() throws InterruptedException {
      Thread shutDown = new Thread(() -> VolatileScenario.shutDown = false);
      new Thread( () ->  work()).start();
      Thread.sleep(50);
      //  as signal inform ohter thread do something ,such as shutdown.
      shutDown.start();
      shutDown.join();
    }

    @Test
    public void moreRead(){
      Thread writer = new Thread(() -> VolatileScenario.write());
      writer.start();
      ExecutorService reader = Executors.newFixedThreadPool(10);
      for(int i =0;i<100;i++)
        reader.submit(()->VolatileScenario.read());

      /*  when reading ,use volatile not sync so faster.when write , use sync so slower.
       * fit read far more chan writer.
       * */
    }


    @Test
    public void array() throws InterruptedException {
      Thread t = new Thread(() -> {
        while (VolatileScenario.a[0] == 1) {
          log.info("not sync yet");
        }
        log.info("sync already");
      });
      t.start();
      Thread.sleep(20);
      a = new int[]{2, 3, 4};
      t.join();
    }

  }
}
