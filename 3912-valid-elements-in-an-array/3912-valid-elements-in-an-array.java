class Solution {
    public List<Integer> findValidElements(int[] nums) {
        int n = nums.length;
        List<Integer> al   = new ArrayList<>();
        if(n==1){
            al.add(nums[0]);
            return al;
        }
        al.add(nums[0]);
        for(int i=1;i<n-1;i++){
            boolean left  = true;
            int dig = nums[i];
            // left
            for(int j=i-1;j>=0;j--){
                if(nums[j]>=dig){
                    left  = false;
                }
            }

            boolean right = true;
            // right
            for(int j=i+1;j<n;j++){
                if(nums[j]>=dig){
                    right = false;
                }
            }

            if(left || right){
                al.add(dig);
            }
        }
        al.add(nums[n-1]);
        return al;
    }
}