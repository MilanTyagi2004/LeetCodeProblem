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
    int recursion(int i,int j,int m,int n){
        if(i>m || j>n){
            return 0;
        }
        if(i==m || j==n){
            return 1;
        }
        int left = recursion(i+1,j,m,n);
        int right = recursion(i,j+1,m,n);
        return left+right;
    }
    public int uniquePaths(int m, int n) {
        // return recursion(0,0,m-1,n-1);

        Integer dp[][] = new Integer[m+1][n+1];
        return memo(0,0,m-1,n-1,dp);
    }
}