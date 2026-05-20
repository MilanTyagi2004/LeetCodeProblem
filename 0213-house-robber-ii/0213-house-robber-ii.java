class Solution {
    int helper(int idx,int n,int nums[],Integer dp[]){
        if(idx>n){
            return 0;
        }
        if(dp[idx]!=null){
            return dp[idx];
        }
        int t =nums[idx]+ helper(idx+2,n,nums,dp);
        int nt = helper(idx+1,n,nums,dp);
        return dp[idx]  = Math.max(t,nt);
    }
    int tabulation(int nums[],int idx,int n){
        int len = n-idx+1;
        int dp[] = new int[len];
        dp[0] = nums[idx];
        dp[1] =Math.max(nums[idx],nums[idx+1]);
        for(int i=2;i<len;i++){
            dp[i] = Math.max(nums[idx+i]+dp[i-2],dp[i-1]);
        }
        return dp[len-1];
    }
    int space(int nums[],int idx,int n){
        if(idx==n){
            return nums[idx];
        }
        int prev= nums[idx];
        int prev1 = Math.max(nums[idx],nums[idx+1]);
        for(int i=idx+2;i<=n;i++){
            int t = nums[i] + prev;
            int nt = prev1;
            int curr  = Math.max(t,nt);
            prev= prev1;
            prev1 = curr;
        }
        return prev1;
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        return  Math.max(space(nums,0,n-2),space(nums,1,n-1));
    }
}