class Solution {
    public int trap(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        int lm = Integer.MIN_VALUE;
        int rm = Integer.MIN_VALUE;
        int total = 0;
        while(l<=r){
            if(nums[l]<=nums[r]){
                if(lm>nums[l]){
                    total += lm-nums[l]; 
                }else{
                    lm = nums[l];
                }
                l=l+1;
            }else{
                if(rm>nums[r]){
                    total += rm-nums[r];
                }else{
                    rm = nums[r];
                }
                r=r-1;
            }
        }
        return total;
    }
}