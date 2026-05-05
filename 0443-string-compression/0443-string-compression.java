class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int i=0,j=0;
        while(i<n){
            char ch = chars[i];
            int cnt=0;
            while(i<n && chars[i]==ch){
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