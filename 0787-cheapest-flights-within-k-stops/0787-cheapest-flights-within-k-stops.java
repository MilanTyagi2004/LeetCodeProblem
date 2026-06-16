import java.util.*;

class Solution {

    class Pair {
        int stops;
        int node;
        int cost;

        Pair(int stops, int node, int cost) {
            this.stops = stops;
            this.node = node;
            this.cost = cost;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, src, 0));
        dist[src] = 0;

        while (!q.isEmpty()) {
            Pair curr = q.poll();

            int stops = curr.stops;
            int node = curr.node;
            int cost = curr.cost;
            if (stops > k) {
                continue;
            }
            for (int[] it : adj.get(node)) {
                int adjNode = it[0];
                int edgeWeight = it[1];
                if (cost + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = cost + edgeWeight;
                    q.offer(
                        new Pair(
                            stops + 1,
                            adjNode,
                            cost + edgeWeight
                        )
                    );
                }
            }
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}