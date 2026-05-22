class Solution {
    int parent[];
    int size[];
    int find(int x){
        if(parent[x]==x){
            return x;
        }
        parent[x] =find(parent[x]);
        return parent[x];
    }

    void union(int x,int y){
        int x_parent = find(x);
        int y_parent = find(y);
        if(x_parent!=y_parent){
            if(size[y_parent]<size[x_parent]){
                parent[y_parent] = x_parent;
                size[x_parent] += size[y_parent]; 
            }else if(size[y_parent]>size[x_parent]){
                parent[x_parent] = y_parent;
                size[y_parent]+=size[x_parent];
            }else{
                parent[y_parent]=x_parent;
                size[x_parent]+=size[y_parent];
            }
        }
    }
    public long countPairs(int n, int[][] edges) {
        parent = new int[n];
        size = new int[n];

        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }

        for(int e[]:edges){
            int u = e[0];
            int v = e[1];
            union(u,v);
        }

        long ans =0;
        long remaining = n;
        for(int i=0;i<n;i++){
            if(parent[i]==i){
                long siz = size[i];
                ans += (siz) * (remaining-siz);
                remaining -= siz; 
            }
        }
        return ans;
    }
}