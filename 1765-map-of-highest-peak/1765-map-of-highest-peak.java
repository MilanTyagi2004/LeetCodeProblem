class Solution {
    public int[][] highestPeak(int[][] grid) {
        Queue<int[]>q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int [][]arr = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    q.offer(new int[]{i,j});
                }else{
                    arr[i][j]=-1;
                }
            }
        }
        int [][]dir = {
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
        };
        while(!q.isEmpty()){
            int [] curr = q.poll();
            for(int it[]:dir){
                int nr = curr[0] + it[0];
                int nc = curr[1] + it[1];

                if(nr>=0 && nr<n && nc>=0 && nc<m &&  arr[nr][nc]==-1){
                    arr[nr][nc]= arr[curr[0]][curr[1]] +1;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
        return arr;
    }
}