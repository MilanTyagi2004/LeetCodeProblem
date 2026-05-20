class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        int prev = nums[0];
        int prev2 = Math.max(nums[1],nums[0]);
        for(int i=2;i<nums.length;i++){
            int t =nums[i]+ prev;
            int nt = prev2;
            int curr = Math.max(t,nt);
            prev= prev2;
            prev2  =curr;
        }
        return prev2;
    }
}