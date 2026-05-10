class Solution {
    void reverse(int [] nums){
        int l=0; 
        int r =  nums.length-1;
        while(l<=r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--; 
        }
    }
    public int[] concatWithReverse(int[] nums) {
        int n = nums.length;
        int arr[] = new int[nums.length+nums.length];
        for(int i=0;i<n;i++){
            arr[i] = nums[i];
        }
        reverse(nums);
        for(int i=0;i<n;i++){
            arr[i+n] = nums[i];
        }
        return arr;
    }
}