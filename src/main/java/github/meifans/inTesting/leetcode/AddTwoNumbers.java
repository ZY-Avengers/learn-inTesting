package github.meifans.inTesting.leetcode;

/**
 * Created by Meifans on 17/4/24.
 */
public class AddTwoNumbers {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    ListNode one = l1;
    ListNode two = l2;
    while (one != null && two != null) {
      one = one.next;
      two = two.next;
    }
    if (one != null) {
      l1 ^= l2;
      l2 ^= l1;
      l1 ^=l2;
    }
    ListNode t = one == null ? (two == null ? null : two) : one;
    int distance = 0;
    while (t != null) {
      t = t.next;
      distance++;
    }

    ListNode result ;
    while (distance-- > 0) {
      result = new ListNode(l2.val);

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