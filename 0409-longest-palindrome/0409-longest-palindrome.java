class Solution {
    public int longestPalindrome(String s) {
        int freq[] = new int[128];
        for(char c:s.toCharArray()){
            freq[c]++;
        }
        int len =0;
        boolean ok = false;
        for(int cnt:freq){
            len += (cnt/2)*2;
            if(cnt%2!=0)ok = true;
        }
        if(ok) len++;
        return len;
    }
}