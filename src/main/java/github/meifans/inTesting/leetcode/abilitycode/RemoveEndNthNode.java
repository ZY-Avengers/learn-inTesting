package github.meifans.inTesting.leetcode.abilitycode;

import github.meifans.inTesting.leetcode.ListNode;

/**
 * @author pengfei.zhao
 */
public class RemoveEndNthNode {
    int count = 0;

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pretender = new ListNode(0);
        pretender.next = head;
        removeEndNth(pretender, n);
        return pretender.next;
    }

    public void removeEndNth(ListNode node, int n) {
        if (node == null) {
            return;
        }
        removeEndNth(node.next, n);
        this.count++;
        if (this.count == n + 1) {
            node.next = node.next.next;
        }
    }
}
