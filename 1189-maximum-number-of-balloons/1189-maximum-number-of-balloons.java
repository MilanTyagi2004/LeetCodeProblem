class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] freq = new int[26];
        for (char c : text.toCharArray()) {
            freq[c - 'a']++;
        }
        int countB = freq['b' - 'a'];
        int countA = freq['a' - 'a'];
        int countL = freq['l' - 'a'] / 2;
        int countO = freq['o' - 'a'] / 2;
        int countN = freq['n' - 'a'];
        return Math.min(
            Math.min(countB, countA),
            Math.min(countL, Math.min(countO, countN))
        );
    }
}