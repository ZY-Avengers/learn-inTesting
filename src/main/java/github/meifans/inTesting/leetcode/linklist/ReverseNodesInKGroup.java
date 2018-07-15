package github.meifans.inTesting.leetcode.linklist;

import github.meifans.inTesting.leetcode.ListNode;

/**
 * @author pengfei.zhao
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode iter = head;
        while (iter != null && count < k) {
            iter = iter.next;
            count++;
        }
        if (count == k) { // mutiple of k
            ListNode nextGroupStart = reverseKGroup(iter, k);
            return reverseKNode(nextGroupStart, head, k);
        }
        return head;
    }

    private ListNode reverseKNode(ListNode left, ListNode cur, int k) {
        if (k > 0) {
            ListNode next = cur.next;
            cur.next = left;
            return reverseKNode(cur, next, k - 1);
        }
        return left;
    }

    public ListNode reverseKGroupII(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        int count = 0;
        ListNode iter = head;
        while (iter != null && count < k) {
            iter = iter.next;
            count++;
        }
        if (count == k) { // mutiple of k
            ListNode left = reverseKGroupII(iter, k);
            while (count-- > 0) {
                ListNode next = head.next;
                head.next = left;
                left = head;
                head = next;
            }
            head = left;
        }
        return head;
    }

}
