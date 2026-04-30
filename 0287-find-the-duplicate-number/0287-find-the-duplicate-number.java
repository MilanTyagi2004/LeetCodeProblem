class Solution {
    public int findDuplicate(int[] nums) {
    Set<Integer>st=new HashSet<>();
    for(int i:nums){
        if(st.contains(i)){
            return i;
        }
        st.add(i);
    }
    return -1;
    }
}