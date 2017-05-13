package github.meifans.inTesting.leetcode;

/**
 * Created by Meifans Zhao on 2017/5/1.
 */
public class RetateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;

        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            length++;
            tail = tail.next;
        }

        if (k >= length)
            k = k % length;

        if (k == 0)
            return head;

        int split = length - k;
        ListNode left = head;
        for (ListNode n = head; n != null; n = n.next) {
            if (--split == 0) {
                left = n.next;
                n.next = null;
                tail.next = head;
                break;
            }
        }
        return left;
    }
}
