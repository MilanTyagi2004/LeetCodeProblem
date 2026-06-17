class Solution {
    // recursive approach 
    int memo(int idx, int prev,int nums[],Integer dp[][]){
        if(idx==nums.length){
            return 0;
        }
        if(dp[idx][prev+1]!=null){
            return dp[idx][prev+1];
        }
        int t =0;
        if(prev ==-1 || nums[prev]<nums[idx]){
            t = 1 + memo(idx+1,idx,nums,dp);
        }
        int nt = memo(idx+1,prev,nums,dp);
        return dp[idx][prev+1]=Math.max(t,nt);
    }
    public int lengthOfLIS(int[] nums) {
        // return rec(0,-1,nums);

        // memo
        Integer dp [][] = new Integer[nums.length+1][nums.length+1];
        // return memo(0,-1,nums,dp);

        // tabulation
        for(int i=0;i<=nums.length;i++){
            dp[nums.length][i] =0;
        }

        for(int i=nums.length-1;i>=0;i--){
            for(int  j=i-1;j>=-1;j--){
                int nt = dp[i+1][j+1];
                int t =0;
                if(j==-1 || nums[j]<nums[i]){
                    t = 1 + dp[i+1][i+1];
                }
                dp[i][j+1] = Math.max(t,nt);
            }
        }
        return dp[0][0];
    }
}