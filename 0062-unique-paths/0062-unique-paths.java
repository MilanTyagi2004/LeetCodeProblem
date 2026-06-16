class Solution {
    int helper(int i,int j,int m,int n,Integer [][] dp){
        if(i==m || j==n){
            return 1;
        }
        if(i>m || j>n){
            return 0;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        int left  = helper(i+1,j,m,n,dp);
        int right = helper(i,j+1,m,n,dp);
        return dp[i][j] =left + right;
    }
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m+1][n+1];
        for(int i=0;i<n;i++){
            dp[0][i] = 1;
        }

        for(int j=0;j<m;j++){
            dp[j][0]= 1;
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                int left = dp[i-1][j];
                int right = dp[i][j-1];
                dp[i][j] = left +right;
            }
        }
        return dp[m-1][n-1];
    }
}