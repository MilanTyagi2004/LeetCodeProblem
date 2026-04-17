class Solution {
    int memo(int i,int j,int m,int n,Integer [][]dp){
        if(i==m || j==n){
            return 1;
        }
        if(i>m || j>n){
            return 0;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        int right  = memo(i+1,j,m,n,dp);
        int down = memo(i,j+1,m,n,dp);
        return dp[i][j] = right+down;
    }
    public int uniquePaths(int m, int n) {
        // return recursion(0,0,m-1,n-1);

        Integer dp[][] = new Integer[m+1][n+1];
        // return memo(0,0,m-1,n-1,dp);
        for(int i=0;i<n;i++){
            dp[0][i] = 1;
        }
        for(int j=0;j<m;j++){
            dp[j][0] =1;
        }

        for(int i=1;i<m;i++){
            for(int j =1;j<n;j++){
                int right = dp[i-1][j];
                int down = dp[i][j-1];
                dp[i][j] = right + down;
            }
        }
        return dp[m-1][n-1];

    }
}