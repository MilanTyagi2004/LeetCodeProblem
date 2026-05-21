class Solution {
    boolean dfs(int i,boolean vis[],boolean []path,ArrayList<ArrayList<Integer>>all){
        vis[i] = true;
        path[i] = true;
        for(int it:all.get(i)){
            if(!vis[it]){
                if(dfs(it,vis,path,all))return true;
            }
                else if(path[it]){
                    return true;
                }
        }
        path[i] =false;
        return false;
    }
    public boolean canFinish(int V, int[][] edges) {
        // main moto is to check if there is any cycle present in this or not .i fpresent then return false if not then return true.

        ArrayList<ArrayList<Integer>> all= new ArrayList<>();
        for(int i=0;i<=V;i++){
            all.add(new ArrayList<>());
        }

        for(int edge[]:edges){
            int u = edge[0];
            int v = edge[1];
            all.get(v).add(u);
        }
        boolean vis[] = new boolean[V];
        boolean path[] = new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
            if(dfs(i,vis,path,all)){
            return false;
            }
        }
        }
        return true;
    }
}