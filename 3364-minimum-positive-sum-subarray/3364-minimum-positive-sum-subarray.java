class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int min = Integer.MAX_VALUE;
        for(int i=l;i<=r;i++){
            int sum =0;
            for(int j=0;j<i;j++){
                sum+=nums.get(j);
            }
            if(sum>0)min = Math.min(min,sum);
            for(int k=i;k<n;k++){
                sum+=nums.get(k);
                sum -= nums.get(k-i);

                if(sum>0){
                    min = Math.min(min,sum);
                }
            }
        }
        return (min==Integer.MAX_VALUE)?-1:min;
    }
}