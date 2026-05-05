class Solution {
    int expand(String s,int left,int right){
        while(left >= 0 && right < s.length() &&
              s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
    public String longestPalindrome(String st) {
        int s=0,e=0;
        int n = st.length();
        for(int i=0;i<st.length();i++){
            int len2 = expand(st,i,i);
            int len1 = expand(st,i,i+1);

            int len = Math.max(len1,len2);
            if(len>e-s){
                s = i-(len-1)/2;
                e = i+len/2;
            }
        }
        return st.substring(s,e+1);
    }
}