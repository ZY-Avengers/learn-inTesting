package github.meifans.inTesting.base;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by siyu on 2017/4/25.
 */
public class DataTypeTest {

  @Test
  public void testByteToString() {
    byte[] bytes = "byte".getBytes();
    String str = new String(bytes);
    Assert.assertEquals("byte",str);
  }

  @Test
  public void testByteToLong() {
    byte[] bytes = "123".getBytes();
    ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
    buffer.put(bytes);
    buffer.flip();
    System.out.println(buffer.getLong());

    byte a = 127;
    byte b = 127;
    b = (byte)( b + a);
    b += a;

    long l = 12;
    double d = l;
  }

  public static void main(String[] args) {
    Class<?> c1 = null;
    try {
      c1 = Class.forName(args[0]);
    } catch (ClassNotFoundException e) {
      System.out.println("class not found");
      System.exit(1);
    }

    Set<String> s = null;
    try {
      s = (Set<String>)c1.newInstance();
    } catch (InstantiationException e) {
      System.out.println("class not instantiable");
      System.exit(1);
    } catch (IllegalAccessException e) {
      System.out.println("class not access");
      System.exit(1);
    }

    s.addAll(Arrays.asList(args).subList(1, args.length));
    System.out.println(s);
  }

}
