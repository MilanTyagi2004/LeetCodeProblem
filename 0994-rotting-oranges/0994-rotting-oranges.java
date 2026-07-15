class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int []>q =new LinkedList<>();
        int fresh = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        int dir[][] = {
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
        };
        int time= 0;
        while(!q.isEmpty()){
            int size  =q.size();
            boolean check = false;
            for(int i=0;i<size;i++){
                
                int curr[] = q.poll();
                
                for(int []d:dir){
                    int nr = curr[0] + d[0];
                    int nc = curr[1] + d[1];

                    if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]==1){
                        grid[nr][nc] = 2;
                        fresh--;
                        check = true;
                        q.offer(new int []{nr,nc});
                    }
                }
            }
            if(check) time++;
        }
        return fresh==0 ? time:-1;
    }
}