class Solution {
    class pair{
        int node;
        int dis;
        pair(int node,int dis){
            this.node = node;
            this.dis = dis;
        }
    }

    int []func(int src,int V,ArrayList<ArrayList<pair>>all){
        PriorityQueue<pair>q = new PriorityQueue<>((a,b)->a.dis - b.dis);
        int []dist =new int[V+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;
        q.add(new pair(src,0));
        while(!q.isEmpty()){
            pair curr = q.poll();
            int u = curr.node;
            for(pair it:all.get(u)){
                int v = it.node;
                int w = it.dis;
                if(dist[u]+w<dist[v]){
                    dist[v] = dist[u]+w;
                    q.add(new pair(v,dist[v]));
                }
            }
        }
        return dist;
    }
    public int networkDelayTime(int[][] edges, int n, int k) {
        ArrayList<ArrayList<pair>> all = new ArrayList<>();
        for(int i=0;i<=n;i++){
            all.add(new ArrayList<>());
        }
        for(int e[]:edges){
            int u =e[0];
            int v = e[1];
            int w = e[2];
            all.get(u).add(new pair(v,w));
        }
        int res[] = func(k,n,all);
        int ans = 0;

        for (int i = 1; i <= n; i++) {

            if (res[i] == Integer.MAX_VALUE) {

                return -1;
            }

            ans = Math.max(ans, res[i]);
        }
        return ans;
    }
}