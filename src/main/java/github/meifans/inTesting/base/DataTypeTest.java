package github.meifans.inTesting.base;

import java.nio.ByteBuffer;
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
}
