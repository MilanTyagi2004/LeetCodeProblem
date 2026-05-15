class Solution {
    public boolean isGood(int[] nums) {
      int max = 0;
      int n = nums.length;
      for(int i=0;i<nums.length;i++){
        max = Math.max(nums[i],max);
      }
      if(n>max+1 || n<max+1){
        return false;
      }

      HashMap<Integer,Integer> mpp = new HashMap<>();
      for(int i:nums){
        mpp.put(i,mpp.getOrDefault(i,0)+1);
      }
      for(int i:nums){
        if(i!=max && mpp.get(i)>1){
            return false;
        }
      }
      if(mpp.get(max)==2){
        return true;
      }
      return false;
    }
}