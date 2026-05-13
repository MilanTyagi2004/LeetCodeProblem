class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> st = new HashSet<>(); 
        int len = 0;
        for(int i:nums){
            st.add(i);
        }
        for(int i:st){
            if(!st.contains(i-1)){
                int curr = i;
                int cnt =1;
                while(st.contains(curr+1)){
                    curr++;
                    cnt++;
                }
                len = Math.max(len,cnt);
            }
        }
        return len;
    }
}