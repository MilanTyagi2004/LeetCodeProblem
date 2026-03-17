class Solution {
    public String removeOuterParentheses(String s) {
        int open = 0;
        StringBuilder sb = new StringBuilder();
        for(char ch:s.toCharArray()){
            if(ch=='('){
                if(open>0){
                sb.append(ch);
                }
                open++;
            }else{
                open--;
                if(open>0)sb.append(ch);
            }
        }
        return sb.toString();
    }
}