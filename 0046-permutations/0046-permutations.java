class Solution {
    void swap(int nums[],int l,int r){
        int temp  = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
    void helper(int idx, int n,int []nums, List<List<Integer>>all){
        if(idx==n){
            List<Integer>al = new ArrayList<>();
            for(int i:nums){
                al.add(i);
            }
            all.add(new ArrayList<>(al));
            return;
        }
        for(int i=idx;i<n;i++){
            swap(nums,i,idx);
            helper(idx+1,n,nums,all);
            swap(nums,i,idx);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        int n =nums.length;
        List<List<Integer>>all =new ArrayList<>();
        helper(0,n,nums,all);
        return all;
    }
}