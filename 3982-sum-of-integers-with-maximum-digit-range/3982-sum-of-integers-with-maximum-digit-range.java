class Solution {

    private int digitRange(int num) {
        int max = 0;
        int min = 9;

        while (num > 0) {
            int d = num % 10;
            max = Math.max(max, d);
            min = Math.min(min, d);
            num /= 10;
        }

       return max - min;
    }
    public int maxDigitRange(int[] nums) {
        int maxRange = 0;
        for (int num : nums) {
            maxRange = Math.max(maxRange, digitRange(num));
        }
        int sum = 0;
        for (int num : nums) {
            if (digitRange(num) == maxRange) {
                sum += num;
            }
        }

        return sum;
    }
}