/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int goodNodes(TreeNode root) {
        int max = Integer.MIN_VALUE;
        return goodNodes(root, max);
    }

    public int goodNodes(TreeNode root, int max) {
        if(root == null) return 0;
        int ans = 0;

        if(root.val >= max) {
            ans++;
            max = root.val;
        };

        ans += goodNodes(root.left,max);
        ans += goodNodes(root.right,max);

        return ans;
    }
}