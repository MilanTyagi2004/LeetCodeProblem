class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Character> st = new HashSet<>();
        for(int i=0;i<word.length();i++){
            st.add(word.charAt(i));
        }
        int cnt =0;
        for(char c:st){
            if(Character.isLowerCase(c)){
                
                if(st.contains(Character.toUpperCase(c))){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}