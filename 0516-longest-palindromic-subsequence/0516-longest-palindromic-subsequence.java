class Solution {
    int vaibhavi(int i,int j,String s,Integer dp[][]){
        if(i>j){
            return 0;
        }
        if(i==j){
            return 1;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        if(s.charAt(i)==s.charAt(j)){
            return 2 + vaibhavi(i+1,j-1,s,dp);
        }
        return dp[i][j] =  Math.max(vaibhavi(i+1,j,s,dp), vaibhavi(i,j-1,s,dp));
    }
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        Integer [][] dp = new Integer[n][n];
        return vaibhavi(0,n-1,s,dp);
    }
}