class Solution {
    int func(int idx,int prev,int nums[],Integer[][]dp){
        if(idx==nums.length){return 0;}
        if(dp[idx][prev+1]!=null){
            return dp[idx][prev+1];
        }
        int t = 0;
        if(prev==-1 || nums[prev]<nums[idx]){
            t = 1+func(idx+1,idx,nums,dp);
        }
        int nt = func(idx+1,prev,nums,dp);
        return dp[idx][prev+1] = Math.max(t,nt);
    }
    public int lengthOfLIS(int[] nums) {
        Integer dp[][] = new Integer[nums.length+1][nums.length+1];
        return func(0,-1,nums,dp);
    }
}