package github.meifans.inTesting.leetcode.linklist;

import github.meifans.inTesting.leetcode.ListNode;

/**
 * @author pengfei.zhao
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode iter = head;
        int cur;
        while (iter != null) {
            if (iter.next != null) {
                cur = iter.val;
                iter.val = iter.next.val;
                iter.next.val = cur;
                iter = iter.next.next;
            } else {
                iter = null;
            }
        }
        return head;
    }
}
