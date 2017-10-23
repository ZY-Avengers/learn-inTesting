package github.meifans.inTesting.leetcode;

import org.junit.Test;

/**
 * point: listnode(2节点交换，快慢指针确定中点,merge过程只剩一个队列时，可以直接指向，而不用while)
 * ,mergesort(merge过程包含2个元素的基本情况)
 *
 * @author pengfei.zhao
 */
public class SortList {


    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head; //base case

        // 1: cut list to two halves
        ListNode pre = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null; //note:cut off pre part

        // 2: sort each half
        ListNode n1 = sortList(head);
        ListNode n2 = sortList(slow);

        // 3:merge n1,n2
        return merge(n1, n2);
    }

    private ListNode merge(ListNode n1, ListNode n2) {
        ListNode merged = new ListNode(0), m = merged;
        while (n1 != null && n2 != null) {
            if (n1.val <= n2.val) {
                m.next = n1;
                n1 = n1.next;
            } else {
                m.next = n2;
                n2 = n2.next;
            }
            m = m.next;
        }
        if (n2 != null) m.next = n2;
        if (n1 != null) m.next = n1;
        return merged.next;
    }


    @Test
    public void test() {
        ListNode head = setUp(2, 1);
        ListNode node = sortList(head);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    private ListNode setUp(int... values) {
        ListNode iter = new ListNode(0), pre = iter;
        for (int val : values) {
            iter.next = new ListNode(val);
            iter = iter.next;
        }
        return pre.next;
    }
}
