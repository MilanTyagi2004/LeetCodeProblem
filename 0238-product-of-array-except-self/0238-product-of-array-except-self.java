class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int prod = 1;
        int newArr [] = new int[n];
        for(int i:nums){
            prod *=i;
        }
        int idx= 0;
        if(prod==0){
            while(idx<n){
                if(nums[idx]==0){
                    break;
                }
                idx++;
            }

        int newProd =1;
        for(int i=0;i<n;i++){
            if(i==idx){
                continue;
            }
            newProd *=nums[i];
        }
        for(int i=0;i<n;i++){
            if(nums[i]!=0){
                newArr[i]=0;
            }else{
                newArr[i] = newProd;
            }
        }
        }else{
            for(int i=0;i<n;i++){
                newArr[i] = prod/nums[i];
        }
        }
        return newArr;
    }
}