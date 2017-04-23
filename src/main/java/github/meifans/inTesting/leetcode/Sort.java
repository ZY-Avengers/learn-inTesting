package github.meifans.inTesting.leetcode;

import lombok.extern.java.Log;
import org.junit.Test;

/**
 * Created by Meifans Zhao on 2017/4/22.
 */
@Log
public class Sort {


    public int[] bubble (int[] a){

        for (int j = a.length - 1; j > 0; j--) {
            for (int i = 0; i < j; i++) {
                if (a[i] > a[i + 1]) {
                    a[i] = a[i] ^ a[i+1];
                    a[i+1] = a[i] ^ a[i + 1];
                    a[i] = a[i] ^ a[i + 1];
                }
            }
        }
        return a;
    }

    public int[] insertion(int[] a ){
        if (a == null && a.length <= 1) {
            return a;
        }
        int star = 1;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                break;
            }
            star = i + 1;
        }

        log.info(star+"o");
        for (int i = star; i < a.length-1; i++) {
            int key = a[i];
            for (int j = i-1; j >=0; j--) {
                if (j == 0 && a[j] > key) {
                    a[j] = a[j] ^ a[j + 1];
                    a[j + 1] = a[j] ^ a[j + 1];
                    a[j] = a[j] ^ a[j + 1];
                    break;
                }
                if (a[j] > key) {
                    a[j + 1] = a[j];
                } else {
                    a[j + 1] = key;
                    break;
                }
            }
        }
        return a;
    }



    @Log
    public static class SortTest {

        @Test
        public void testSort(){
//            int[] a = {2,3,2,7,4,6,4,8};
            int[] a = {2,3,4,4,8};

            int[] actual = new Sort().insertion(a);
            for (int i : actual) {
                log.info(""+i);
            }
        }
    }

}
