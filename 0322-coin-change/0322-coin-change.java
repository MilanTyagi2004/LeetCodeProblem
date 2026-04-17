class Solution {
    int memo(int i, int n,int target,int coins[],Integer [][]dp){
        if(target==0){
            return 0;
        }
        if(i==n){
            return (int) 1e9;
        }
        if(dp[i][target]!=null){
            return dp[i][target];
        }
        int take =(int) 1e9;
        if(coins[i]<=target){
        take = 1+ memo(i,n,target-coins[i],coins,dp);
        }
        int notTake = memo(i+1,n,target,coins,dp);
        return dp[i][target] = Math.min(take,notTake);
    }
    public int coinChange(int[] coins, int amount) {
        Integer dp [] [] = new Integer[coins.length][amount+1];
        int n = coins.length;
        int ans = memo(0,n,amount,coins,dp);
        return (ans>=(int) 1e9)?-1:ans;
    }
}