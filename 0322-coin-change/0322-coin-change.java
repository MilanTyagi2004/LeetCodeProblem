class Solution {
    public int coinChange(int[] nums, int amount) {
        int [] dp =  new int[amount+1];
        Arrays.fill(dp,(int)1e9);
        dp[0] = 0;
        for(int i:nums){
            for(int j=i;j<=amount;j++){
                dp[j] = Math.min(dp[j],1+dp[j-i]);
            }
        }
        return dp[amount]==(int)1e9?-1:dp[amount];
    }
}