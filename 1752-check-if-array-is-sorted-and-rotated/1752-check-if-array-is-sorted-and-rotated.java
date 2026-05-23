class Solution {
    public boolean check(int[] nums) {
        int arr[] = nums.clone();
        int idx = 0;
        int n = nums.length;
        while(idx<n){
            int temp = arr[0];
            for(int i=0;i<arr.length-1;i++){
                arr[i] = arr[i+1];
            }
            arr[nums.length-1] =temp;
            boolean same = true;
            for(int i=0;i<n-1;i++){
                if(arr[i]>arr[i+1]){
                    same = false;
                    break;
                }
            }
            if(same){
                return true;
            }
            idx++;
        }
        return false;
    }
}