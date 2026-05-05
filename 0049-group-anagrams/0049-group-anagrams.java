class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> mpp = new HashMap<>();
        for(String s:strs){
            int [] freq = new int[26];
            for(char ch:s.toCharArray()){
                freq[ch-'a']++;
            }
            String str = Arrays.toString(freq);
            mpp.putIfAbsent(str,new ArrayList<>());
            mpp.get(str).add(s);
        }
        return new ArrayList<>(mpp.values());
    }
}