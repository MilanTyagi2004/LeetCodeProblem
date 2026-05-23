class Solution {
    public int minimumSwaps(int[] nums) {
        int zero = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                zero++;
            }
        }
        int ans = 0;
        for(int i=nums.length-1;i>nums.length-1-zero;i--){
            if(nums[i]!=0){
                ans++;
            }
        }
        return ans;
    }
}