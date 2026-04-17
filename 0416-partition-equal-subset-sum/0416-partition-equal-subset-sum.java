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
        total  = total/2;
        boolean dp[][] = new boolean[nums.length+1][total+1];
        for(int j=0;j<=nums.length;j++){
            dp[j][0]  = true;
        }
        // tabulation 
        for(int i=nums.length-1;i>=0;i--){
            for(int j = 0;j<=total;j++){
                boolean take = false;
                if(nums[i]<=j){
                    take = dp[i+1][j-nums[i]];
                }
                boolean nottake = dp[i+1][j];
                dp[i][j] =take || nottake; 
            }
        }
        return dp[0][total];
    }
}