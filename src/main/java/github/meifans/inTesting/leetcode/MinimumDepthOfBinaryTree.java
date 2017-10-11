package github.meifans.inTesting.leetcode;

/**
 * @author pengfei.zhao
 */
public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int r = minDepth(root.right), l = minDepth(root.left);
        return r * l == 0 ? r + l + 1 : Math.min(r, l) + 1;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
