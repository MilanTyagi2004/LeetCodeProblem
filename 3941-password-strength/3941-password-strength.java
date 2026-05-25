class Solution {
    public int passwordStrength(String password) {
        Set<Character>st = new HashSet<>();
        for(char ch:password.toCharArray()){
            st.add(ch);
        }
        int sum=0;
        for(char c:st){
            int dig = (int)c;
            if(dig>=48 && dig<=57){
                sum+=3;
            }else if(dig>=65 && dig<=90){
                sum+=2;
            }else if(dig>=97 && dig<=122){
                sum+=1;
            }else{
                sum+=5;
            }
        }
        return sum;
    }
}