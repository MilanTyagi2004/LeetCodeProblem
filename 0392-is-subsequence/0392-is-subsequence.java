class Solution {
    public boolean isSubsequence(String s, String t) {
        int i=0;
        int j =0;
        int n = s.length();
        int m = t.length();
        if(n==0){
            return true;
        }
        if(m==0){
            return false;
        }
        while(j<m){
            if(s.charAt(i)==t.charAt(j)){
                if(i==n-1){
                    return true;
                }
                i++;
                j++;
            }else if(s.charAt(i)!=t.charAt(j)){
                j++;
            }
        }
        return i==n;
    }
}