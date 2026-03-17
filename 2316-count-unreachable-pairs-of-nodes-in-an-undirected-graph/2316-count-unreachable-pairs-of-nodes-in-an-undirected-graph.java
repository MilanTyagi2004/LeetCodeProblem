class Solution {
    int [] parent;
    int [] rank;
    int find(int i){
        if(i==parent[i]){
            return i;
        }
        parent[i] = find(parent[i]);
        return parent[i];
    }
    void rank_union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) return;
        if (rank[px] < rank[py]) {
            parent[px] = py;
        } else if (rank[px] > rank[py]) {
            parent[py] = px;
        } else {
            parent[py] = px;
            rank[px]++;
        }
    }
    public long countPairs(int n, int[][] edges) {
        parent  = new int[n];
        rank  = new int[n];
        Arrays.fill(rank,0);
        for(int i=0;i<n;i++){
            parent[i] = i;
        }

        for(int []edge :edges){
            int u = edge[0];
            int v = edge[1];
            rank_union(u,v);
        }

        Map<Integer,Integer> mpp = new HashMap<>();
        for(int i=0;i<n;i++){
            int father = find(i);
            mpp.put(father,mpp.getOrDefault(father,0)+1);
        }

        long result = 0;
        long remaining  =n;

        for(Map.Entry<Integer,Integer>entry:mpp.entrySet()){
            long size = entry.getValue();
            result += size * (remaining - size);
            remaining -= size;
        }
        return result;
    }
}