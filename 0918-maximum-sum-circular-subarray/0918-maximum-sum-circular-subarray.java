class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int currsum = 0;
        int maxsum = nums[0];

        int currmin =0;
        int minsum = nums[0];

        int total = 0;
        for(int i:nums){
            currsum = Math.max(i,currsum+i);
            maxsum = Math.max(currsum, maxsum);

            currmin = Math.min(i,currmin+i);
            minsum = Math.min(currmin,minsum);
            total +=i;
        }
        return maxsum<0?maxsum:Math.max(maxsum,total-minsum);
    }
}