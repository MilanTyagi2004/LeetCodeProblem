class Solution {
    int memo(int i,int nums[],Integer dp[]){
        if(i>=nums.length){
            return 0;
        }
        if(dp[i]!=null){
            return dp[i];
        }
        int take = nums[i] + memo(i+2,nums,dp);
        int notTake = memo(i+1,nums,dp);
        return dp[i]=Math.max(take,notTake);
    }
    public int rob(int[] nums) {
        Integer dp []=new Integer[nums.length+1]; 
        return memo(0,nums,dp);
    }
}