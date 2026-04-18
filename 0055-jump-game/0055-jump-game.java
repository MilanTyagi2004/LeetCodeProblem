class Solution {
    boolean helper(int i,int[] nums,Boolean dp[]){
        if(i==nums.length-1){
            return true;
        }
        if(i>=nums.length){
            return true;
        }
        if(dp[i]!=null){
            return dp[i];
        }
        for(int idx =1;idx<=nums[i];idx++){
            if(helper(i+idx,nums,dp)==true){
                return dp[i] =true;
            }
        }
        return dp[i] =false;
    }
    public boolean canJump(int[] nums) {
        Boolean dp[]= new Boolean[nums.length+1];
        return helper(0,nums,dp);
    }
}