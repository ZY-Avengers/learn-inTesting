package github.meifans.inTesting.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 重点
 * point:线性时间内寻找中位数
 *
 * 范畴：选择算法中的快速选择算法，来源于快排，改进：bfprt改进选取pivot。
 *
 * @author pengfei.zhao
 */
public class WiggleSortII {


    public void wiggleSortI(int[] nums) {
        int l = nums.length, k = (l + 1) / 2;  //避免k=0情况，findKthII空指针
        int mid = findKthII(nums, k);

        int i = 0, j = 0, n = nums.length - 1;
        while (j <= n) {
            if (nums[map(l, j)] > mid) swap(nums, map(l, i++), map(l, j++));
            else if (nums[map(l, j)] < mid) swap(nums, map(l, j), map(l, n--));
            else j++;
        }

    }

    private int map(int n, int x) {
        return (2 * x + 1) % (n | 1);
    }


    private int findKth(int[] nums, int k) {
        if (nums.length < 1500) {
            Arrays.sort(nums);
            return nums[k - 1];
        }
        return findKtI(nums, k);
    }

    private int findKtI(int[] nums, int k) {
        int x = 0, s = 0, e = nums.length - 1;
        while (x != k) {
            x = findRandom(nums, s, e);
            if (x < k) s = x + 1;
            if (x > k) e = x - 1;
        }
        return nums[k];
    }

    private int findKthII(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            maxHeap.offer(nums[i]);
            if (maxHeap.size() > k) maxHeap.poll();
        }
        return maxHeap.peek();
    }

    /**
     * 错很多，重点回顾
     */
    private int findRandom(int[] nums, int s, int e) {
        int i = s;
        for (int m = nums[e]; s <= e; s++) {
            if (nums[s] > m) ;
            else swap(nums, s, i++);
        }
        return i - 1;
    }

    private void swap(int[] nums, int i, int e) {
        int val = nums[i];
        nums[i] = nums[e];
        nums[e] = val;
    }

    @Test
    public void test() {
        int[] nums = new int[2000];
        for (int i = 0; i < 1000; i++) {
            nums[i] = (int) (Math.random() * 1000);
        }
        this.wiggleSortI(nums);
        for (int num : nums) {
            System.out.print(num);
        }
    }

    @Test
    public void testFindK() {
        testFindKNums(10);
        testFindKNums(100);
        testFindKNums(500);
        testFindKNums(1000);
        testFindKNums(1500);
        testFindKNums(10000);
        testFindKNums(100000);
        testFindKNums(1000000);
    }

    private void testFindKNums(int n) {
        System.out.println("test nums:" + n);
        int[] numsI = new int[n];
        int[] numsII = new int[n];
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            numsI[i] = (int) (Math.random() * 1000);
            numsII[i] = (int) (Math.random() * 1000);
            nums[i] = (int) (Math.random() * 1000);
        }
        long start = System.currentTimeMillis();

        findKtI(numsI, (numsI.length + 1) / 2);
        long i = System.currentTimeMillis();

        findKthII(numsII, (numsII.length + 1) / 2);
        long ii = System.currentTimeMillis();

        findKth(nums, (numsII.length + 1) / 2);
        long I = System.currentTimeMillis();


        System.out.println("i:" + (i - start));
        System.out.println("ii:" + (ii - i));
        System.out.println("I:" + (I - ii));
    }

}
