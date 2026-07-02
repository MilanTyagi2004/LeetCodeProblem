class Solution {

    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    boolean dfs(int i, int j, List<List<Integer>> all, int health, boolean[][] vis,Integer [][] dp) {

        int n = all.size();
        int m = all.get(0).size();

        if (i < 0 || j < 0 || i >= n || j >= m)
            return false;

        if (vis[i][j])
            return false;

        if (all.get(i).get(j) == 1)
            health--;

        if(dp[i][j]!=null&&dp[i][j] >= health){
            return false;
        }
        dp[i][j] = health;
        if (health <= 0)
            return false;
        if (i == n - 1 && j == m - 1)
            return true;

        vis[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int nr = i + dx[k];
            int nc = j + dy[k];

            if (dfs(nr, nc, all, health, vis,dp))
                return true;
        }
        vis[i][j] = false;
        return false;
    }

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        Integer dp[][] = new Integer[grid.size()][grid.get(0).size()];
        return dfs(0, 0, grid, health,
                new boolean[grid.size()][grid.get(0).size()],dp);
    }
}