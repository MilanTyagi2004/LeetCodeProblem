class Solution {
    public int jump(int[] nums) {
        int cnt=0;
        int far =0;
        int j=0;
        for(int i=0;i<nums.length-1;i++){
            far = Math.max(far,nums[i]+i);
            if(i==j){
                cnt++;
                j = far;
            }
        }
        return cnt;
    }
}