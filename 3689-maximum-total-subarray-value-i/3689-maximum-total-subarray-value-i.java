class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        for(int i:nums){
            max = Math.max(max,i);
            min = Math.min(min,i);
        }
        return (max-min) *k; 
    }
}