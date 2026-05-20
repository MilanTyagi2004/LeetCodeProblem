class Solution {
    boolean helper(int i,int j,int idx,char[][] board,String word){
        if(idx==word.length()){
            return true;
        }
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]!=word.charAt(idx)){
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '#';
        boolean found =
                helper(i + 1, j, idx + 1, board, word) ||
                helper(i - 1, j, idx + 1, board, word) ||
                helper(i, j + 1, idx + 1, board, word) ||
                helper(i, j - 1, idx + 1, board, word);
        board[i][j]=temp;
        return found;
    }
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(helper(i,j,0,board,word))return true;
            }
        }
        return false;  
    }
}