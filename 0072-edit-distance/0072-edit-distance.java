class Solution {
    int helper(int i,int j,String word1 ,String word2,Integer dp[][]){
        if(i==word1.length()){
            return word2.length() - j;
        }
        if(j==word2.length()){
            return word1.length()- i;
        }
        if(word1.charAt(i) ==  word2.charAt(j)){
            return helper(i+1,j+1,word1,word2,dp);
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        int l = helper(i,j+1,word1,word2,dp);
        int f = helper(i+1,j,word1,word2,dp);
        int g = helper(i+1,j+1,word1,word2,dp);

        return dp[i][j] = 1 + Math.min(l,Math.min(f,g));
    }
    public int minDistance(String word1, String word2) {
        Integer dp[][] = new Integer[word1.length()+1][word2.length()+1];
        int m = word1.length();
        int n = word2.length();
        for(int i = 0; i <= m; i++){
            dp[i][0] = i;
        }
        for(int j = 0; j <= n; j++){
            dp[0][j] = j;
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(word1.charAt(i)==word2.charAt(j)){
                    dp[i][j] = dp[i-1][j-1];
                }
                int l = dp[i][j-1];
                int r = dp[i-1][j];
                int g = dp[i-1][j-1];

                dp[i][j] =1+ Math.min(l,Math.min(r,g));
            }
        }
        return dp[m][n];
    }
}