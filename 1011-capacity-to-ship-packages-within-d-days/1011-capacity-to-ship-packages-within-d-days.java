class Solution {
    int func(int []wt,int cap){
        int day=1;
        int load=0;
        for(int i=0;i<wt.length;i++){
            if(load+wt[i]>cap){
                day ++;
                load = wt[i];
            }else{
                load+=wt[i];
            }
        }
        return day;
    }
    int function(int[]wt,int day){
        int max = 0;
        int sum =0;
        for(int i:wt){
            max =Math.max(max,i);
            sum +=i;
        }
        int l = max;
        int r = sum;
        while(l<=r){
            int mid = l + (r-l)/2;
            int noOfDays = func(wt,mid);
            if(noOfDays<=day){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return l;
    }
    public int shipWithinDays(int[] weights, int days) {
        return function(weights,days);
    }
}