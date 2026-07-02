class Solution {

    class Pair {
        int node;
        int cost;

        Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    public int minCostConnectPoints(int[][] points) {

        int n = points.length;
        boolean[] vis = new boolean[n];
        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> a.cost - b.cost);

        pq.offer(new Pair(0, 0));
        int ans = 0;
        int count = 0;

        while (count < n) {

            Pair cur = pq.poll();
            if (vis[cur.node])
                continue;

            vis[cur.node] = true;
            ans += cur.cost;
            count++;

            for (int i = 0; i < n; i++) {
                if (!vis[i]) {

                    int dist = Math.abs(points[cur.node][0] - points[i][0]) +
                               Math.abs(points[cur.node][1] - points[i][1]);

                    pq.offer(new Pair(i, dist));
                }
            }
        }
        return ans;
    }
}