class Solution {
    public int maxArea(int[] nums) {
        int l =0;
        int r = nums.length-1;
        int max =0;
        while(l<r){
            int len = r-l;
            int area = Math.min(nums[l],nums[r]) * len;
            max = Math.max(max,area);
            if(nums[l]<nums[r]){
                l++;
            }
            else{
                r--;
            }
        }
        return max;
    }
}