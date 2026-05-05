class Solution {
    public String convert(String s, int numRows) {
        int n =s.length();
        if(numRows==1){
            return s;
        }
        ArrayList<StringBuilder> al = new ArrayList<>();

        for(int i=0;i<numRows;i++){
            al.add(new StringBuilder());
        }
        int i=0;
        boolean change = false;
        for(char c:s.toCharArray()){
            al.get(i).append(c);

            if(i==0 || i==numRows-1){
                change = !change;
            }
            i += change?1:-1;
        }
        StringBuilder sbs = new StringBuilder();
        for(StringBuilder sb:al){
            sbs.append(sb);
        }
        return sbs.toString();
    }
}