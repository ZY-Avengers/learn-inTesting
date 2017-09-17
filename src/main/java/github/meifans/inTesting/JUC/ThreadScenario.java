package github.meifans.inTesting.JUC;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Random;

import lombok.extern.java.Log;

/**
 * Created by Meifans on 17/4/21.
 */
@Log
public class ThreadScenario {

  static ThreadScenario toTest = new ThreadScenario();

  static final int max = 10;

  static LinkedList<Integer> queue = new LinkedList<>();


  @Log
  public static class ThreadTest {

    @Test
    public void  testWait() throws InterruptedException {
      Thread consumer = new Thread(() -> {
        try {
          toTest.consume();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      });
      consumer.start();

      Thread producer = new Thread(() -> {
        try {
          toTest.produce();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      });
      producer.start();

      Thread.sleep(200);

    }

  }

  public  void produce() throws InterruptedException {

    while (true) {
      synchronized (toTest) {
        while (queue.size() == max) {
          log.info("queue is max");
          toTest.wait();
        }

        int next = new Random().nextInt();
        queue.add(next);
        log.info("produce:" + next);
        toTest.notifyAll();
      }
    }
  }

  public  void consume() throws InterruptedException {
    while (true) {
      synchronized (toTest) {
        while (queue.isEmpty()) {
          log.info("queue is empty");
          toTest.wait();
        }

        log.info("consume:"+queue.remove());
        toTest.notifyAll();
      }
    }
  }

}
