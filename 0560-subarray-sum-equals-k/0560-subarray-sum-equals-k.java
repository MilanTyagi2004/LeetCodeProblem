class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> mpp = new HashMap<>();
        mpp.put(0,1);
        int sum=0;
        int cnt=0;
        for(int i:nums){
            sum +=i;
            if(mpp.containsKey(sum-k)){
                cnt+=mpp.get(sum-k);
            }
                mpp.put(sum,mpp.getOrDefault(sum,0)+1);
        }
        return cnt;
    }
}