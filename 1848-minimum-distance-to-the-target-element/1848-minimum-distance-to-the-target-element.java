class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int val = Integer.MAX_VALUE;
        int  n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==target){
                val = Math.min(val, Math.abs(i-start));
            }
        }
        return val;
    }
}