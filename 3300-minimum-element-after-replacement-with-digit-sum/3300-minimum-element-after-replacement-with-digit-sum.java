class Solution {
    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int r = nums[i];
            int sum = 0;
            while(r!=0){
                int dig = r%10;
                sum+=dig;
                r = r/10;
            }
            min = Math.min(sum,min);
        }
        return min;
    }
}