package github.meifans.inTesting.leetcode.abilitycode;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author pengfei.zhao
 */
public class PalindromeNumber {

    /**
     * 考察点：
     *
     * 1、整数的位移操作
     * 2、负数的情况
     */
    public boolean isPalindrome(int x) { //5851
//        long t1 = System.nanoTime();
        if (x < 0) {
            return false;
        }

        int temp = x;
        int k = 0;
        while (temp > 0) {
            if ((k * 10 + temp % 10) > Integer.MAX_VALUE) {
                return false;
            }

            k = k * 10 + temp % 10;
            temp /= 10;
        }

//        System.out.println(System.nanoTime() - t1);
        return k == x;
    }

    public boolean isPalindromeIII(int x) {
        if (x < 0)
            return false;
        if (x < 10)
            return true;

        int tens = 1;
        int temp = x;
        while ((temp /= 10) > 0) tens *= 10;

        while (tens >= 10) {
            if (x / tens != x % 10) {
                return false;
            }
            x = x % tens / 10;
            tens /= 100;
        }

        return true;
    }


    /**
     * String s = String.valueOf(x);
     * for (int i = 0, j = s.length() - 1; i < s.length(); i++, j--) {
     * if (s.charAt(i) != s.charAt(j)) {
     * return false;
     * }
     * }
     * 2段时间分别为40335 8013
     *
     * 数值计算比访问对象更快些
     */

    @Test
    public void test() {
        PalindromeNumber tester = new PalindromeNumber();
        Assert.assertTrue(tester.isPalindromeIII(1111111111));//40335  2:8013
    }

    /**
     * leetcode
     */
    public boolean isPalindromeII(int x) {
        // if(x==Integer.MIN_VALUE) return false;
        if (x < 0)
            return false; //isPalindrome(-x);
        if (x < 10)
            return true;

        int tens = 1;
        int tmp = x;
        while (tmp / 10 > 0) {
            tens *= 10;
            tmp = tmp / 10;
        }

        while (tens >= 10) {
            if (x / tens != x % 10)
                return false;
            x = x % tens / 10;
            tens /= 100;
        }
        return true;
    }


}
