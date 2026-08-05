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
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        rightView(root, ans, -1, q);
        return ans;
    }
    public void rightView(TreeNode root, List<Integer> ans, int currLevel, Queue<TreeNode> q) {
        while(!q.isEmpty()) {
            int size = q.size();

            for(int i = 0; i < size; i++) {
                TreeNode p = q.poll();
                int val = p.val;

                if(i == size-1) {
                    ans.add(val);
                }

                if(p.left != null) q.offer(p.left);
                if(p.right != null) q.offer(p.right);
            }
        }
        
    }

}