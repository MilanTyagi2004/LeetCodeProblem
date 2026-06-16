class Solution {
    void dfs(int [][] grid,int sr, int sc,int color,int newColor){
        if(sr<0 || sr>= grid.length || sc<0 || sc>=grid[0].length  || grid[sr][sc]!=newColor ){
            return;
        }
        grid[sr][sc] = color;
        dfs(grid,sr+1,sc,color,newColor);
        dfs(grid,sr-1,sc,color,newColor);
        dfs(grid,sr,sc+1,color,newColor);
        dfs(grid,sr,sc-1,color,newColor);

    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color)
        return image;
        dfs(image, sr, sc, color,image[sr][sc]);
        return image;
    }
}