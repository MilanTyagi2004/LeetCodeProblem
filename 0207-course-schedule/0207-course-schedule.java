class Solution {
    public boolean canFinish(int V, int[][] edges) {
        // now use toposort to detect cycle in this
        ArrayList<ArrayList<Integer>>all = new ArrayList<>();
        for(int i=0;i<V;i++){
            all.add(new ArrayList<>());
        } 
        for(int edge[]:edges){
            int u =edge[0];
            int v =edge[1];
            all.get(v).add(u);
        }
        int [] degree = new int[V];
        for(ArrayList<Integer>al:all){
            for(int it:al){
                degree[it]++;
            }
        }
        Queue<Integer>q = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(degree[i]==0){
                q.add(i);
            }
        }
        int cnt=0;
        while(!q.isEmpty()){
            cnt++;
            int node= q.poll();
            for(int it:all.get(node)){
                degree[it]--;
                if(degree[it]==0){
                    q.add(it);
                }
            }
        }
        return cnt==V;
    }
}