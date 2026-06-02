class Solution {
    public int compress(char[] chars) {
        int i= 0;
        int j =0;
        int n  = chars.length;
        while(i<n){
            char ch = chars[i];
            int cnt =0;
            while(i<n && ch==chars[i] ){
                i++;
                cnt++;
            }
            chars[j++] = ch;
            if(cnt>1){
                String str = String.valueOf(cnt);
                for(char c:str.toCharArray()){
                    chars[j++] = c;
                }
            }
        }
        return j;
    }
}