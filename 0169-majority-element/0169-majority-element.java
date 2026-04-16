class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> mpp = new HashMap<>();
        for(int i : nums){
            mpp.put(i,mpp.getOrDefault(i,0)+1);
        }
        int max = Integer.MIN_VALUE;
        for(Map.Entry<Integer,Integer> entry:mpp.entrySet()){
            max = Math.max(max,entry.getValue());
        }
        for(int i:nums){
            if(mpp.get(i)==max){
                return i;
            }
        }
        return -1;
    }
}