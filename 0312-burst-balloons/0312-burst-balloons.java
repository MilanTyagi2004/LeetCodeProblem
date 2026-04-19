class Solution {
    int[][] dp;

    int helper(int i, int j, int[] nums){
        if(i > j) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int max = 0;

        for(int idx = i; idx <= j; idx++){
            int cost = nums[i-1] * nums[idx] * nums[j+1]
                     + helper(i, idx-1, nums)
                     + helper(idx+1, j, nums);

            max = Math.max(max, cost);
        }

        return dp[i][j] = max;
    }

    public int maxCoins(int[] nums) {
        int n = nums.length;

        int[] newNums = new int[n + 2];
        newNums[0] = newNums[n+1] = 1;

        for(int i = 0; i < n; i++){
            newNums[i+1] = nums[i];
        }

        dp = new int[n+2][n+2];
        for(int[] row : dp) Arrays.fill(row, -1);

        return helper(1, n, newNums);
    }
}