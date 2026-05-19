class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>all = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1])continue;
            int j = i+1;
            int k = n-1;
            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum>0){
                    k--;
                }
                else if(sum<0){
                    j++;
                }
                else{
                    List<Integer>al = new ArrayList<>();
                    al.add(nums[i]);
                    al.add(nums[j]);
                    al.add(nums[k]);
                    j++;
                    k--;
                    while(j<k && nums[j]==nums[j-1]){
                        j++;
                    }
                    while(j<k && nums[k]==nums[k+1]){
                        k--;
                    }
                    all.add(al);
                }
            }
        }
        return all;
    }
}