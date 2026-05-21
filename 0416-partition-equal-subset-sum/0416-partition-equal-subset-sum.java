class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int total =0;
        for(int i:nums){
            total+=i;
        }
        if(total%2!=0){
            return false;
        }
        int target = total/2;
        boolean dp [][] = new boolean [n+1][target+1];
        for(int i=0;i<=n;i++){
            dp[i][0] = true;
        }
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=target;j++){
                boolean t =false;
                if(nums[i]<=j){
                    t = dp[i+1][j-nums[i]];
                }
                boolean nt = dp[i+1][j];
                dp[i][j] = t||nt;
            }
        }
        return dp[0][target];
    }
}