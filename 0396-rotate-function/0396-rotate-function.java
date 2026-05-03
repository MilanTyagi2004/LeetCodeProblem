class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sum =0;
        long p=0;
        for(int i=0;i<nums.length;i++){
            sum +=nums[i];
            p +=(long) i* nums[i];
        }
        long max = p;
        long prev = p;

        for(int i=1;i<nums.length;i++){
            long curr   = prev + sum -(long) n* nums[n-i];
            max = Math.max(curr,max);
            prev = curr;
        }
        return (int)max;
    }
}