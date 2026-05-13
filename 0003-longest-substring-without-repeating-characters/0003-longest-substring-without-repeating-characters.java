class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character>st = new HashSet<>();
        int i=0;
        int j=0;
        int n = s.length();
        int max =0;
        while(j<n){
            if(!st.contains(s.charAt(j))){
                st.add(s.charAt(j));
                max = Math.max(j-i+1,max);
                j++;
            }else{
                st.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }
}