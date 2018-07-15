package github.meifans.inTesting.leetcode.sort;

import github.meifans.inTesting.leetcode.ListNode;

/**
 * @author pengfei.zhao
 */
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int s1 = 0;
        int s2 = (lists.length + 1) / 2;
        int length = lists.length;
        while (length > 1) {
            mergeFoldLists(s1, s2, length, lists);
            length = s2;
            s2 = (length + 1) / 2;
        }
        return lists[0];
    }

    public void mergeFoldLists(int s1, int s2, int length, ListNode[] lists) {
        while (s1 < s2 && s2 < length) {
            ListNode mergedHeader = merge(lists[s1], lists[s2]);
            lists[s1] = mergedHeader;
            lists[s2] = null;
            s1++;
            s2++;
        }
    }

    private ListNode merge(ListNode s1, ListNode s2) {
        ListNode header = new ListNode(0);
        ListNode iter = header, pre;
        while (s1 != null && s2 != null) {
            if (s1.val <= s2.val) {
                pre = s1.next;
                iter.next = s1;
                s1.next = null;
                s1 = pre;
            } else {
                pre = s2.next;
                iter.next = s2;
                s2.next = null;
                s2 = pre;
            }
            iter = iter.next;
        }
        if (s1 != null) {
            iter.next = s1;
        } else if (s2 != null) {
            iter.next = s2;
        }
        return header.next;
    }

}
