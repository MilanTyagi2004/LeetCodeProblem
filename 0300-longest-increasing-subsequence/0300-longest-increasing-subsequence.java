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
        int n = nums.length;
        Integer dp[] [] = new Integer [nums.length+1][nums.length+1];
        for(int i=0;i<=nums.length;i++){
            dp[nums.length][i] = 0;
        }
        for(int i=n-1;i>=0;i--){
            for(int j = i-1;j>=-1;j--){
                int nt = dp[i+1][j+1];
                int take = 0;
                if(j==-1 || nums[j]<nums[i]){
                    take = 1+dp[i+1][i+1];
                }
                dp[i][j+1] = Math.max(take,nt);
            }
        }
        return dp[0][0];
    }
}