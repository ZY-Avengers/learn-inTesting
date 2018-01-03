package github.meifans.inTesting.base;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;

import lombok.extern.java.Log;

import static org.junit.Assert.assertEquals;

/**
 * Created by Meifans on 17/4/13.
 */
@Log
public class SugarScenario {


  @Test
  public void forEachAndWhile() {
    Iterator i = Arrays.asList(new String[]{"a", "b"}).iterator();

    while (i.hasNext()) {
      String s = (String) i.next();
      log.info(s);
    }

    int var3 = 0;

    while (var3++ < 100) {
      log.info("" + var3);
    }
  }

  @Test
  public void testMethodCall(){
    Object value = 3;
    String s = String.valueOf(value);
    System.out.println(s);
  }  @Test
  public void testMethodCalld(){
    Object value = 3;
    String s = String.valueOf(value);
    System.out.println(s);
  }

  @Log
  public static class SugarTest {

    @Test
    public void forEachAndWhile() {

      for (String s : Arrays.asList("a", "b")) {
        log.info(s);
      }

      int i = 0;
      while (i++ < 100) {
        log.info("" + i);
      }
    }

    @Test
    public void add() {
      byte i = 127;
      byte k = 127;

      assertEquals(254,(i+k));
      assertEquals((byte) (i + k), i += k);  //i+k atom cast int ，but i += k ，byte add direct.
    }

    @Test
    public void _byte() {
      assertEquals((byte) 0x80, -128);
      assertEquals((byte)0xff,-1);
    }
  }
}
