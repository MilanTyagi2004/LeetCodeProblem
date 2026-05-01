class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        HashSet<Integer> st = new HashSet<>();
        int el = 0;
        int sum=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(st.contains(grid[i][j])){
                    el = grid[i][j];
                }
                st.add(grid[i][j]);
                sum += grid[i][j];
            }
        }
        sum -= el;
        int size = grid.length;
        int newSum=0;
        for(int i=1;i<=size*size;i++){
            newSum+=i;
        }
        return new int[]{el,newSum-sum};
    }
}