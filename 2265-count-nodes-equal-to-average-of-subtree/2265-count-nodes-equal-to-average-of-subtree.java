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

    public int[] findAvg(TreeNode root) {
        if(root == null) {
            return new int[] {0,0};
        }

        int[] left = new int[2];
        int[] right = new int[2];

        if(root.left != null) left = findAvg(root.left);
        if(root.right != null) right = findAvg(root.right);

        long sum = left[0] + right[0] + root.val;
        int i = left[1] + right[1] + 1;

        if(sum / i == root.val) {
            ans++;
        }

        return new int[] {(int) sum, i};
    }

    // private long findSum(TreeNode root) {
    //     if(root.left == null && root.right == null) return root.val;
    //     long left = 0,right = 0;

    //     if(root.left != null){
    //         i++;
    //         left = findSum(root.left);
    //     }
    //     if(root.right != null){
    //         i++;
    //         right = findSum(root.right);
    //     }

    //     return left + right + root.val ;
    // }
}