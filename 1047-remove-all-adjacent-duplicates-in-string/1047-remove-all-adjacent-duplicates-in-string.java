class Solution {
    public String removeDuplicates(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        // for(int i=)
        Stack<Character> st  =new Stack<>();
        for(char ch:s.toCharArray()){
            if(!st.isEmpty() && st.peek()==ch ){
                st.pop();
            }else{
            st.push(ch);
            }
        }

        while(!st.isEmpty()){
            char c = st.peek();
            st.pop();
            sb.append(c);
        }
        return sb.reverse().
        toString();
    }
}