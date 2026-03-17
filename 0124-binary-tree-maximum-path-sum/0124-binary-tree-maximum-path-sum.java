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
    private int maxSum = Integer.MIN_VALUE;
    public int dfs(TreeNode root){
        if(root==null)return 0;
        int leftgain = Math.max(0,dfs(root.left));
        int rightgain = Math.max(0,dfs(root.right));
        int fgain = root.val + (leftgain + rightgain);
        maxSum = Math.max(maxSum,fgain);
        return root.val + Math.max(leftgain ,rightgain);
    }
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }
}