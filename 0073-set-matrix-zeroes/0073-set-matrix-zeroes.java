class Solution {
    public void setZeroes(int[][] nums) {
        int n = nums.length;
        int m = nums[0].length;
        boolean row[] = new boolean[n];
        boolean col[] = new boolean[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(nums[i][j]==0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(row[i] || col[j]){
                    nums[i][j]=0;
                }
            }
        }


        
    }
}