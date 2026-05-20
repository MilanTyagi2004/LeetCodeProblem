class Solution {
    void helper(int idx,int n,int nums[],List<List<Integer>>all,List<Integer>al,int target){
        if(idx==n ){
            if(target==0){
            all.add(new ArrayList<>(al));
        }
            return;
        }
        if(target>=nums[idx]){
            al.add(nums[idx]);
            helper(idx,n,nums,all,al,target-nums[idx]);
            al.remove(al.size()-1);
        }
        helper(idx+1,n,nums,all,al,target);
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>>all = new ArrayList<>();
        helper(0,n,nums,all,new ArrayList<>(),target);
        return all;
    }
}