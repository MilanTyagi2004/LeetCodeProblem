class Solution {
    public int firstUniqueEven(int[] nums) {
        Map<Integer,Integer> mpp = new HashMap<>();
        int n = nums.length;
        for(int i:nums) mpp.put(i,mpp.getOrDefault(i,0)+1);
        int even = -1;
        for(int i:nums){
            if(i%2==0 && mpp.get(i)==1){
                even = i;
                break;
            }
        }
        return even;
    }
}