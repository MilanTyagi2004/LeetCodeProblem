class Solution {
    public String sortVowels(String s) {

        Map<Character, Integer> freq = new HashMap<>();
        Map<Character, Integer> first = new HashMap<>();
        List<Character> vowels = new ArrayList<>();

        // Step 1: collect + count + first occurrence
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (isVowel(ch)) {
                vowels.add(ch);

                freq.put(ch, freq.getOrDefault(ch, 0) + 1);

                // store first occurrence only once
                first.putIfAbsent(ch, i);
            }
        }

        // Step 2: sort by (freq desc, first occurrence asc)
        vowels.sort((a, b) -> {
            if (!freq.get(a).equals(freq.get(b))) {
                return freq.get(b) - freq.get(a);
            }
            return first.get(a) - first.get(b);
        });

        // Step 3: replace back
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