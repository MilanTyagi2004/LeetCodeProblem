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
    void helper(TreeNode root,int target , List<List<Integer>> all,List<Integer>al){
        if(root==null){
            return;
        }
        al.add(root.val);
        if(root.left==null && root.right==null && target==root.val){
            all.add(new ArrayList<>(al));
        }else{
            helper(root.left,target-root.val,all,al);
            helper(root.right,target-root.val,all,al);
        }
        al.remove(al.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>>all = new ArrayList<>();
        List<Integer> al = new ArrayList<>();
        helper(root, targetSum, all,al);
        return all;
    }
}