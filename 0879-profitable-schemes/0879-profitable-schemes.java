class Solution {
    int MOD = 1000000007;
    int[][][] dp = new int [101][101][101];

    public int solve(int k, int i, int j, int n, int minProfit, int[] group, int[] profit) {
        if (k == profit.length) {
            if (j >= minProfit && n >= i) return 1;
            return 0;
        } 
        else if (n < i) return 0;

        if (dp[k][i][j] != -1) return dp[k][i][j];

        int notInclude = solve(k + 1, i, j, n, minProfit, group, profit);

        int include = solve(
            k + 1,
            i + group[k],
            Math.min(j + profit[k], minProfit),
            n,
            minProfit,
            group,
            profit
        );

        return dp[k][i][j] = (include % MOD + notInclude % MOD) % MOD;
    }
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        for (int a = 0; a < 102; a++) {
    for (int b = 0; b < 102; b++) {
        Arrays.fill(dp[a][b], -1);
    }
}
        return solve(0,0,0,n,minProfit,group,profit);
    }
}