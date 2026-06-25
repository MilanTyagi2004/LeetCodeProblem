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
    void dfs(TreeNode root,List<Integer>al){
        if(root==null){
            return;
        }
        al.add(root.val);
        dfs(root.left,al);
        dfs(root.right,al);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> al  =new ArrayList<>();
        dfs(root,al);
        return al;
    }
}