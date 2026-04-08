import java.util.*;

class Solution {

    class Pair {
        int row, col, dist;
        Pair(int r, int c, int d) {
            row = r;
            col = c;
            dist = d;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        // If start or end is blocked
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;

        // Directions (8 moves)
        int[] dr = {-1,-1,-1,0,0,1,1,1};
        int[] dc = {-1,0,1,-1,1,-1,0,1};

        // Distance array
        int[][] dist = new int[n][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.dist - b.dist);

        dist[0][0] = 1;
        pq.offer(new Pair(0, 0, 1));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int r = curr.row, c = curr.col, d = curr.dist;

            // Reached destination
            if (r == n-1 && c == n-1) return d;

            for (int i = 0; i < 8; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nc >= 0 && nr < n && nc < n && grid[nr][nc] == 0) {
                    if (d + 1 < dist[nr][nc]) {
                        dist[nr][nc] = d + 1;
                        pq.offer(new Pair(nr, nc, d + 1));
                    }
                }
            }
        }

        return -1;
    }
}