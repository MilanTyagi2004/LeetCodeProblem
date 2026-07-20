class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> all = new ArrayList<>();
        char [][] grid = new char[n][n];
        for(char []i:grid){
            Arrays.fill(i,'.');
        }
        helper(0,n,grid,all);
        return all;
    }
    void helper(int row,int n,char[][]grid,List<List<String>>all){
        if(row==n){
            all.add(construct(grid));
        }
        for(int col =0;col<n;col++){
            if(check(row,col,n,grid)){
                grid[row][col] ='Q';
                helper(row+1,n,grid,all);
                grid[row][col] ='.';
            }
        }
    }
    List<String> construct(char board[][]){
        List<String>al = new ArrayList<>();
        for(char i[]:board){
            al.add(new String(i));
        }
        return al;
    }
    boolean check(int row, int col,int n,char [][]grid){
        for(int i=0;i<row;i++){
            if(grid[i][col]=='Q'){
                return false;
            }
        }

        for(int i=row-1,j=col-1;i>=0&&j>=0; i--,j--){
            if(grid[i][j]=='Q')return false; 
        }

        for(int i=row-1,j=col+1;i>=0 && j<n;i--,j++){
            if(grid[i][j]=='Q')return false;
        }
        return true;
    }
}