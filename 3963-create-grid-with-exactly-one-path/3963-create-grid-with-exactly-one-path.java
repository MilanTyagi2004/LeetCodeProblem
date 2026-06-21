class Solution {
    public String[] createGrid(int m, int n) {
        String[][] ans = new String[m][n];

        int i = 0, j = 0;

        while (i < m) {
            ans[i][j] = ".";
            i++;
        }

        i = m - 1;

        while (j < n) {
            ans[i][j] = ".";
            j++;
        }

        for (int a = 0; a < m; a++) {
            for (int b = 0; b < n; b++) {
                if (ans[a][b] == null) {
                    ans[a][b] = "#";
                }
            }
        }

        String[] result = new String[m];

        for (int a = 0; a < m; a++) {
            result[a] = String.join("", ans[a]);
        }

        return result;
    }
}