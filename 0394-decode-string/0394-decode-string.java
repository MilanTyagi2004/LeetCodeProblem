class Solution {
    public String decodeString(String s) {
        Stack<Integer> cnt =new Stack<>();
        Stack<StringBuilder> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int el = 0;
        for(char ch:s.toCharArray()){
            if(Character.isDigit(ch)){
                el = el*10 + (ch-'0');
            }else if(ch=='['){
                cnt.push(el);
                st.push(sb);
                el = 0;
                sb = new StringBuilder();
            }else if(ch==']'){
                int count = cnt.pop();
                StringBuilder prev = st.pop();
                for(int i=0;i<count;i++){
                    prev.append(sb);
                }
                sb = prev;
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}