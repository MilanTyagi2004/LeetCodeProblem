class Solution {
    void helper(int image[][],int i,int j,int color,int newColor){
        if(i<0 || j<0 || i>=image.length || j>=image[0].length || image[i][j]!=color || image[i][j] ==newColor){
            return;
        }
        image[i][j]=newColor;
        helper(image,i+1,j,color,newColor);
        helper(image,i,j+1,color,newColor);
        helper(image,i-1,j,color,newColor);
        helper(image,i,j-1,color,newColor);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        helper(image,sr,sc,image[sr][sc],color);
        return image;
    }
}