package github.meifans.inTesting.JUC;

import java.util.Arrays;
import java.util.Iterator;
import java.util.UUID;
import lombok.extern.java.Log;
import org.junit.Test;

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
    public void UUID(){
      log.info(String.valueOf(UUID.randomUUID()));
    }
  }
}
