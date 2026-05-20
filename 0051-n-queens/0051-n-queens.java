class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>>all = new ArrayList<>();
        char board[][] = new char[n][n];
        for(char r[]:board){
            Arrays.fill(r,'.');
        }
        helper(0,n,board,all);
        return all;
    }
    void helper(int row,int n, char board[][],List<List<String>>all){
        if(row==n){
            all.add(construct(board));
        }
        for(int col=0;col<n;col++){
            if(check(row,col,n,board)){
                board[row][col]='Q';
                helper(row+1,n,board,all);
                board[row][col]='.';
            }
        }
    }
    List<String> construct(char[][] board){
        List<String> al = new ArrayList<>();
        for(char r[]:board){
            al.add(new String(r));
        }
        return al;
    }
    boolean check(int row,int col,int n, char[][]board){
        for(int i=0;i<row;i++){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        for(int i=row-1 , j=col-1;i>=0&&j>=0;j--,i--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        for(int i=row-1,j=col+1;i>=0&&j<n;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
}