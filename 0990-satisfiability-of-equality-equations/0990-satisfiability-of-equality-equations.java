class Solution {
    int [] parent;
    int [] rank;
    int find(int i){
        if(i==parent[i]){
            return parent[i];
        }
        parent[i] = find(parent[i]);
        return parent[i];
    }

    void union (int x,int y){
        int x_parent = find(x);
        int y_parent = find(y);
        if(x_parent==y_parent)return ;
        if(rank[x_parent]>rank[y_parent]){
            parent[y_parent] =  x_parent;
        }
        else if(rank[x_parent]<rank[y_parent]){
            parent[x_parent] = y_parent;
        }
        parent[y_parent] = x_parent;
        rank[y_parent]++;
    }

    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        rank = new int[26];

        for(int i=0;i<26;i++){
            parent[i] = i;
        }
        for(String eq : equations){
    char[] s = eq.toCharArray();

    if(s[1] == '='){
        union(s[0] - 'a', s[3] - 'a');
    }
}
        for(String eq:equations){
            char []s = eq.toCharArray();
            if(s[1]=='!'){
                char first = s[0];
                char second  =s[3];
                int fist_parent = find(first-'a');
                int second_parent = find(second-'a');

                if(fist_parent==second_parent){
                    return false;
                }
            }
        }
        return true;
    }
}