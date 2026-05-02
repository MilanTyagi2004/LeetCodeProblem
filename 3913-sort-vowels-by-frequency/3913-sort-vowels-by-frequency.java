class Solution {
    public String sortVowels(String s) {

        Map<Character, Integer> freq = new HashMap<>();
        Map<Character, Integer> first = new HashMap<>();
        List<Character> vowels = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (isVowel(ch)) {
                vowels.add(ch);
                freq.put(ch, freq.getOrDefault(ch, 0) + 1);
                first.putIfAbsent(ch, i);
            }
        }

        vowels.sort((a, b) -> {
            if (!freq.get(a).equals(freq.get(b))) {
                return freq.get(b) - freq.get(a);
            }
            return first.get(a) - first.get(b);
        });
        StringBuilder sb = new StringBuilder(s);
        int idx = 0;

        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                sb.setCharAt(i, vowels.get(idx++));
            }
        }
        return sb.toString();
    }

    private boolean isVowel(char ch) {
        return ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u';
    }
}