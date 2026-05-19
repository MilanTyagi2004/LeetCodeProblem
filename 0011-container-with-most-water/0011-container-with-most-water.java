class Solution {
    public int maxArea(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        int lm = Integer.MIN_VALUE;
        int rm =Integer.MIN_VALUE;
        int area = 0;
        while(l<r){
            if(lm<nums[l]){
                lm = nums[l];
            }
            if(rm<nums[r]){
                rm = nums[r];
            }
            int len = r-l;
            int prod = len * Math.min(nums[l],nums[r]);
            area = Math.max(prod,area);
           if (nums[l] < nums[r]) {
                l++;
            } else {
                r--;
            }
        }
        return area;
    }
}