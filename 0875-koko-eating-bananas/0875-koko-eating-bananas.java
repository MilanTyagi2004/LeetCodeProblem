class Solution {
    public int minEatingSpeed(int[] nums, int h) {
        int l=1;
        int r =0;
        for(int i:nums){
            r = Math.max(i,r);
        }
        while(l<=r){
            int mid = l + (r-l)/2;
        long k= 0;
            for(int i:nums){
                k+=(int) Math.ceil((double)i/mid);
            }
            if(k>h)l = mid+1;
            else r = mid-1;
        }
        return l;
    }
}