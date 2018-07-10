package github.meifans.inTesting.leetcode.abilitycode;

import github.meifans.inTesting.leetcode.ListNode;

/**
 * @author pengfei.zhao
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode iter = head;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                iter.next = l2;
                l2 = l2.next;
                iter = iter.next;
            } else {
                iter.next = l1;
                l1 = l1.next;
                iter = iter.next;
            }
        }

        ListNode post = l1 == null ? l2 : l1;
        iter.next = post;
        return head.next;
    }
}
