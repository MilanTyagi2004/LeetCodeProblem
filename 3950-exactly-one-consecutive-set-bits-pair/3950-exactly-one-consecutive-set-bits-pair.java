class Solution {
    public boolean consecutiveSetBits(int n) {
        int cnt=0;
        int prev = 0;
        while(n>0){
            int curr = n&1;
            if(curr==1 && prev==1){
                cnt++;
            }
            prev = curr;
            n>>=1;
        }
        return cnt==1;
    }
}