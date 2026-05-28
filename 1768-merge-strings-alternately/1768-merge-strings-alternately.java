class Solution {
    public String mergeAlternately(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int i=0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        while(i<n && j<m){
            sb.append(s1.charAt(i));
            i++;
            sb.append(s2.charAt(j));
            j++;
        }
        while(i<n){
            sb.append(s1.charAt(i));
            i++;
        }
        while(j<m){
            sb.append(s2.charAt(j));
            j++;
        }
        return sb.toString();
    }
}