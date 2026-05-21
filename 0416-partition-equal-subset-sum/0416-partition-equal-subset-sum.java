class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int total = 0;
        for(int i:nums){
            total+=i;
        }
        if(total%2!=0){
            return false;
        }
        int target = total/2;
        boolean dp[] = new boolean[target+1];
        dp[0] = true;
        for(int i:nums){
            for(int j=target;j>=i;j--){
                boolean take =dp[j-i];
                boolean nt = dp[j];
                dp[j] = take||nt;
            }
        }
        return dp[target];
    }
}