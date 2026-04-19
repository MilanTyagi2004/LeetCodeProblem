class Solution {
    HashSet<String>st= new HashSet<>();
    void helper(int i,String s,String curr,List<String>al){
        if(i>=s.length()){
            al.add(curr);
            return;
        }
        for(int j=i;j<s.length();j++){
            String word = s.substring(i,j+1);
            if(st.contains(word)){
                String temp = curr;
                curr += (curr.isEmpty() ? "" : " ") + word;
                helper(j+1,s,curr,al);
                curr = temp;
            }
        }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
    List<String>al = new ArrayList<>();

    for(String word:wordDict){
        st.add(word);
    }
    helper(0,s,"",al);
    return al;    
    }
}