class Solution {
    int ans=Integer.MAX_VALUE;
    class pair{
        int node;
        int dist;
        pair(int node,int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    public int minScore(int n, int[][] roads) {
        ArrayList<ArrayList<pair>>all = new ArrayList<>();
        for(int i=0;i<=n;i++){
            all.add(new ArrayList<>());
        }

        for(int i[]:roads){
            int u=i[0];
            int v = i[1];
            int w=i[2];
            all.get(u).add(new pair(v,w));
            all.get(v).add(new pair(u,w));
        }
        boolean vis[] = new boolean[n+1];
        dfs(1,vis,all);
        return ans;
    }
    void dfs(int src,boolean vis[],ArrayList<ArrayList<pair>>all){
        vis[src] = true;
        // pair curr = all.get(src);
        for(pair it:all.get(src)){
            int v = it.node;
            int wt = it.dist;
            ans =Math.min(ans,wt);
            if(!vis[v]){
                dfs(v,vis,all);
            }
        }
    }
}