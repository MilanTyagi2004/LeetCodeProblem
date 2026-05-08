class Solution {
    public int longestMountain(int[] nums) {
        int n = nums.length;
        int maxLen = 0;

        int i = 1;

        while (i < n - 1) {

            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {

                int left = i;
                int right = i;

                while (left > 0 && nums[left] > nums[left - 1]) {
                    left--;
                }

                while (right < n - 1 && nums[right] > nums[right + 1]) {
                    right++;
                }

                int length = right - left + 1;
                maxLen = Math.max(maxLen, length);

                i = right;
            } else {
                i++;
            }
        }

        return maxLen;
    }
}