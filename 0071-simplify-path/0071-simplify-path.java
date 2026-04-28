class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        Stack<String> st = new Stack<>();
        for(String word:arr){
            if(word.equals(".") || word.equals("")){
                continue;
            }
            else if( word.equals("..")){
                if(!st.isEmpty()){
                    st.pop();
                }
            }else{
                st.push(word);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String e:st){
            sb.append("/").append(e);
        }
        return sb.isEmpty()? "/":sb.toString();
    }
}