class Solution {
    void helper(int idx,int n,int[]nums,List<List<Integer>>all, List<Integer>al){
        if(idx==n){
            all.add(new ArrayList<>(al));
            return;
        }
        al.add(nums[idx]);
        helper(idx+1,n,nums,all,al);
        al.remove(al.size()-1);
        helper(idx+1,n,nums,all,al);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> all =new ArrayList<>();
        int n = nums.length;
        helper(0,n,nums,all,new ArrayList<>());
        return all;
    }
}