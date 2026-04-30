class Solution {
    public int maxSubArray(int[] nums) {
        int val = nums[0];
        int max = nums[0];
        for(int i=1;i<nums.length;i++){
            val = Math.max(nums[i],nums[i]+val);
            max = Math.max(max,val);
        }
        return max;
    }
}