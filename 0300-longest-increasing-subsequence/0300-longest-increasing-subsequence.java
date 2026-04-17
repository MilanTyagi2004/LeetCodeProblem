class Solution {
    int recursion(int i,int prev,int []nums,Integer dp[][]){
        if(i==nums.length){
            return 0;
        }
        if(dp[i][prev+1]!=null){
            return dp[i][prev+1];
        }
        int nottake = recursion(i+1,prev,nums,dp);
        int take = 0;
        if(prev==-1 || nums[i]>nums[prev]){
            take = 1 + recursion(i+1,i,nums,dp);
        }
        return dp[i][prev+1] = Math.max(take,nottake);
    }
    public int lengthOfLIS(int[] nums) {
        Integer dp[] [] = new Integer [nums.length][nums.length+1];
        return recursion(0,-1,nums,dp);
    }
}