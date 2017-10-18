package github.meifans.inTesting.leetcode;

/**
 * @author pengfei.zhao
 */
public class BSTSearch {

    public Node bstSearch(Node node, int target) {
        if (node == null) return null;
        if (node.val == target) return node;
        if (node.val < target) return bstSearch(node.right, target);
        return bstSearch(node.left, target);
    }

    class Node {
        int val;
        Node left;
        Node right;
    }
}