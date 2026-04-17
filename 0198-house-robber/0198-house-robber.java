class Solution {
    public int rob(int[] nums) {
        Integer dp []=new Integer[nums.length+1]; 
        dp[0] = nums[0];
        dp[1] =Math.max(nums[0],nums[1]);

        for(int i=2;i<nums.length;i++){
            int notTake = dp[i-1];
             int take = nums[i] + dp[i-2];
             dp[i]= Math.max(take,notTake);
        }
        return dp[nums.length-1];
    }
}