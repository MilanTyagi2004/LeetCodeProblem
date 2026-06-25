class Solution {
    public int countMajoritySubarrays(int[] n, int target) {
        int cnt=0;
        for(int i=0;i<n.length;i++){
            int curr=0;
            for(int j=i;j<n.length;j++){
                if(n[j]==target){
                    curr++;
                }
                int length = j-i+1;
                if(curr*2>length){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}