class Solution {
    boolean memo(int i,int target, int[] nums, Boolean dp [][]){
        if(target==0){
            return true;
        }
        if(i==nums.length){
            return false;
        }
        if(dp[i][target]!=null){
            return dp[i][target];
        }
        boolean take = false;
        if(nums[i]<=target){
        take = memo(i+1,target-nums[i],nums,dp);
        }
        boolean nottake = memo(i+1,target,nums,dp);
        return dp[i][target] = take|| nottake;  
    }
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int i:nums){
            total +=i;
        }
        if(total%2!=0){
            return false;
        }
        Boolean dp[][] = new Boolean[nums.length+1][total+1];
        return memo(0,total/2,nums,dp);

    }
}