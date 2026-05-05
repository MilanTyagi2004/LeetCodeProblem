class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character>st = new HashSet<>();
        int n = s.length();
        int max= 0;
        int i=0;
        int j =0;
        while(j<n){
            char ch =s.charAt(j);
            if(!st.contains(ch)){
                st.add(ch);
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