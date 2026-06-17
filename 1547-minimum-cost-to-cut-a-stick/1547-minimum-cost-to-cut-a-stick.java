class Solution {
    // recursive approach by codewithmik
    int solve(int [] cuts,int l, int r){
        if(r-l <2){
            return 0;
        }

        int res = Integer.MAX_VALUE;
        for(int i=l+1;i<=r-1;i++){
            int cost = (cuts[r] - cuts[l]) + solve(cuts,l,i) + solve(cuts,i,r);
            res = Math.min(res,cost);
        }
        return res;
    }
    // now memo approach by myself
    int memo(int [] arr, int l, int r, Integer dp[][]){
        if(r-l< 2){
            return 0;
        }
        if(dp[l][r]!=null){
            return dp[l][r];
        }
        int ans = Integer.MAX_VALUE;
        for(int i=l+1;i<=r-1;i++){
            int cost = (arr[r] -arr[l]) + memo(arr,i,r,dp) + memo(arr,l,i,dp);
            ans  = Math.min(ans,cost); 
        }
        return dp[l][r] = ans;
    }
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);

        int[] arr = new int[cuts.length + 2];

        arr[0] = 0;
        arr[arr.length - 1] = n;

        for (int i = 0; i < cuts.length; i++) {
            arr[i + 1] = cuts[i];
        }

        // memo
        int m = arr.length;
        Integer dp[][] = new Integer[m][m];
        return memo(arr,0,m-1,dp);
    }
}