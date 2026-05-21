class Solution {
    public int minDistance(String s, String s1) {
        int n = s.length();
        int m =s1.length();
        int prev[] =new int[m+1];
        for(int i=0;i<=m;i++){
            prev[i] = i;
        }
        for(int i=1;i<=n;i++){
            int curr[] = new int[m+1];
            curr[0]=i;
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==s1.charAt(j-1)){
                    curr[j] = prev[j-1];
                }
                else{
                    int insert = curr[j - 1];

                    int delete = prev[j];

                    int replace = prev[j - 1];

                    curr[j] = 1 + Math.min(insert,
                                  Math.min(delete, replace));
                }
            }
            prev = curr;
        }
        return prev[m];
    }
}