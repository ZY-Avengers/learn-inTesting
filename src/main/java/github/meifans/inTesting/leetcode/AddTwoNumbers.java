package github.meifans.inTesting.leetcode;

import java.util.ArrayList;
import lombok.extern.java.Log;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Meifans on 17/4/24.
 */
public class AddTwoNumbers {


  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode start = new ListNode(0);
    ListNode iter = start;
    int bit = 0, sum = 0;
    while (l1 != null && l2 != null) {
      sum = l1.val + l2.val + bit;
      iter.next = new ListNode(sum > 9 ? sum - 10 : sum);
      bit = sum > 9 ? 1 : 0;
      l1 = l1.next;
      l2 = l2.next;
      iter = iter.next;
    }
    ListNode s = l1 == null ? l2 : l1;
    while (s != null) {
      sum = s.val + bit;
      iter.next = new ListNode(sum > 9? sum -10:sum);
      bit = sum > 9 ? 1 : 0;
      s = s.next;
      iter = iter.next;
    }
    if(bit ==1) iter.next = new ListNode(1);

    return start.next;
  }

  @Log
  public static class AddTwoNumbersTest {

    @Test
    public void test() {
      int v = Integer.MAX_VALUE;
      log.info(v + "max");
      log.info("" + (v << 1));

      long l = 1 << 62;
      log.info("" + l);
    }


    @Test
    public void testAddTwoNumbers() {
      int[] one = {2, 4, 3};
      int[] two = {5, 6, 4};
      Integer[] expected = {7, 0, 8};

      assertArray(one, two, expected);

    }

    @Test
    public void testAddTwoNumbers_1() {
      int[] one = {5};
      int[] two = {5};
      Integer[] expected = {0, 1};

      assertArray(one, two, expected);

    }

    @Test
    public void testAddTwoNumbers_2() {
      int[] one = {1, 8};
      int[] two = {0};
      Integer[] expected = {1, 8};

      assertArray(one, two, expected);

    }

    @Test
    public void testAddTwoNumbers_3() {
      int[] one = {9, 8};
      int[] two = {1};
      Integer[] expected = {0, 9};

      assertArray(one, two, expected);

    }


    private void assertArray(int[] one, int[] two, Integer[] expected) {
      ListNode l1 = getListNode(one);
      ListNode l2 = getListNode(two);

      Assert.assertArrayEquals(expected, toArray(addTwoNumbers(l1, l2)));
    }

    private static ListNode getListNode(int[] a) {
      ListNode start = new ListNode(0);
      ListNode iter = start;
      for (int i : a) {
        iter.next = new ListNode(i);
        iter = iter.next;
      }
      return start.next;
    }

    private static Integer[] toArray(ListNode n) {
      ArrayList<Integer> l = new ArrayList<>();
      while (n != null) {
        l.add(n.val);
        n = n.next;
      }
      return l.toArray(new Integer[l.size()]);
    }

  }

}

class ListNode {

  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}