class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<int[]>[] graph = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int [] e:edges){
            graph[e[0]].add(new int[]{e[1],e[2]});
        }
        long maxi = Long.MAX_VALUE;
        long [][] dist = new long[n][k+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],maxi);
        }
        PriorityQueue<long []>pq = new PriorityQueue<>(Comparator.comparingLong(a->a[0]));
        dist[0][1]=0;
        pq.offer(new long[]{0,0,1});

        while(!pq.isEmpty()){
            long[] cur = pq.poll();
            long d = cur[0];
            int u = (int) cur[1];
            int r = (int)cur[2];

            if(d!=dist[u][r]) continue;

            for(int [] edge : graph[u]){
                int v = edge[0];
                int w = edge[1];
                int next;
                if(labels.charAt(v)==labels.charAt(u)){
                    next = r+1;
                }else{
                    next =1;
                }
                if(next>k)continue;
                long nd = d+w;
                if(nd<dist[v][next]){
                    dist[v][next]=nd;
                    pq.offer(new long[]{nd, v, next});
                }
            }
        }

        long res= maxi;
        for(int i=1;i<=k;i++){
            res= Math.min(res, dist[n-1][i]);
        }
        return res==(int)maxi ? -1:(int)res;
    }
}