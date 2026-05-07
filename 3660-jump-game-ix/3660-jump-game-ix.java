class Solution {

    public int[] maxValue(int[] nums) {

        int n = nums.length;

        int[] bigPrefix = new int[n];
        int[] smallSuffix = new int[n];

        bigPrefix[0] = nums[0];
        smallSuffix[n - 1] = nums[n - 1];

        for(int i = 1; i < n; i++) {
            bigPrefix[i] = Math.max(nums[i], bigPrefix[i - 1]);
        }

        for(int i = n - 2; i >= 0; i--) {
            smallSuffix[i] = Math.min(nums[i], smallSuffix[i + 1]);
        }

        int[] ans = new int[n];

        ans[n - 1] = bigPrefix[n - 1];

        for(int i = n - 2; i >= 0; i--) {

            if(bigPrefix[i] > smallSuffix[i + 1]) {
                ans[i] = ans[i + 1];
            }
            else {
                ans[i] = bigPrefix[i];
            }
        }

        return ans;
    }
}