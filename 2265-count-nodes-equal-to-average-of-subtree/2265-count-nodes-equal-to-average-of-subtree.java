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
    int ans = 0;

    public int averageOfSubtree(TreeNode root) {
        findAvg(root);
        return ans;
    }
    int i = 1;

    public void findAvg(TreeNode root) {
        if(root == null) {
            return;
        }
        i = 1;
        long sum = findSum(root);

        if(sum / i == root.val) {
            ans++;
        }
        if(root.left != null) findAvg(root.left);
        if(root.right != null) findAvg(root.right);

        return;
    }

    private long findSum(TreeNode root) {
        if(root.left == null && root.right == null) return root.val;
        long left = 0,right = 0;

        if(root.left != null){
            i++;
            left = findSum(root.left);
        }
        if(root.right != null){
            i++;
            right = findSum(root.right);
        }

        return left + right + root.val ;
    }
}