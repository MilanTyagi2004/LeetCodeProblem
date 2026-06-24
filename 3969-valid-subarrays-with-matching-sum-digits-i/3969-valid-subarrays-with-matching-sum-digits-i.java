class Solution {
    public int countValidSubarrays(int[] nums, int x) {
        int n = nums.length;
        int count = 0;        
        for (int i = 0; i < n; i++) {
            long currS = 0;            
            for (int j = i; j < n; j++) {
                currS += nums[j];                
                if (currS % 10 == x) {
                    long temp = currS;
                    while (temp >= 10) {
                        temp /= 10;
                    }                    
                    if (temp == x) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}