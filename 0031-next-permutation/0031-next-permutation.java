class Solution {
    public void nextPermutation(int[] nums) {
        int gola_index = -1;
        int n = nums.length;

        // Find pivot
        for (int i = n - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                gola_index = i - 1;
                break;
            }
        }

        // Find element just greater than pivot and swap
        if (gola_index != -1) {
            int swap_index = gola_index + 1;

            for (int i = n - 1; i > gola_index; i--) {
                if (nums[i] > nums[gola_index]) {
                    swap_index = i;
                    break;
                }
            }

            swap(nums, swap_index, gola_index);
        }

        // Reverse the remaining part
        reverse(nums, gola_index + 1, n - 1);
    }

    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}