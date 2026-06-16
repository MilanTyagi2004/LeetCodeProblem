class Solution {
    int vaibhavi(int i,int j,String s){
        if(i>j){
            return 0;
        }
        if(i==j){
            return 1;
        }
        if(s.charAt(i)==s.charAt(j)){
            return 2 + vaibhavi(i+1,j-1,s);
        }
        return Math.max(vaibhavi(i+1,j,s), vaibhavi(i,j-1,s));
    }
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int dp[][] = new int[n][n];

        for(int i=n-1;i>=0;i--){
            dp[i][i] = 1;
            for(int j=i+1;j<n;j++){
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j] = 2 + dp[i+1][j-1];
                }else{
                   dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }
}