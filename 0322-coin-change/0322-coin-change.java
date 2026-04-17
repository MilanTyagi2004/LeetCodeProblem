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
        Integer dp [] [] = new Integer[coins.length+1][amount+1];

        int n = coins.length;

        for(int i=0;i<=n;i++){
            dp[i][0] = 0;
        }
        for(int t = 0;t<=amount;t++){
            dp[n][t] = (int) 1e9;
        }

        for(int i=n-1;i>=0;i--){
            for(int j = 1;j<=amount;j++){
                int take = (int) 1e9;
                if(coins[i]<=j){
                    take = 1+ dp[i][j-coins[i]];
                }
                int notTake = dp[i+1][j];
                dp[i][j] = Math.min(take,notTake);
            }
        }
        int ans =dp[0][amount];
        return (ans>=(int)1e9) ? -1 : ans;
    }
}