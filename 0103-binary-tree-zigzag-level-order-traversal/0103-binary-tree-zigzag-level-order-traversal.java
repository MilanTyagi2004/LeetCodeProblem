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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> all = new ArrayList<>();
        if(root==null)return all;
        Queue<TreeNode>q = new LinkedList<>();
        q.offer(root);
        boolean flag = true;
        while(!q.isEmpty()){
            LinkedList<Integer>l = new LinkedList<>();
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode node=  q.poll();
                if(flag){
                    l.addLast(node.val);
                }else{
                    l.addFirst(node.val);
                } 
                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }
            all.add(l);
            flag = !flag;
        }
        return all;
    }
}