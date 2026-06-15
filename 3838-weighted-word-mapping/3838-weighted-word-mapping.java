class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb  = new StringBuilder();
        for(String word:words){
            int total = 0;
            for(char c:word.toCharArray()){
                total +=weights[c-'a'];
            }
            int append  = total%26;
            char cp = (char) ('z'-append);
            sb.append(cp);
        }
        return sb.toString();
    }
}