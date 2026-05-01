class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int el = 0;
        int el2 =0;
        int cnt=0;
        int cnt1=0;
        for(int i:nums){
            if(i==el){
                cnt++;
            }else if(i==el2){
                cnt1++;
            }else if(cnt==0){
                el = i;
                cnt=1;
            }else if(cnt1==0){
                el2 = i;
                cnt1 =1;
            }else{
                cnt--;
                cnt1--;
            }
        }
            cnt=0;
            cnt1=0;
            for(int i : nums){
                if(i==el)cnt++;
                else if(i==el2)cnt1++;
            }
            List<Integer>al = new ArrayList<>();
            if(cnt>n/3)al.add(el);
            if(cnt1>n/3)al.add(el2); 
        return al;
    }
}