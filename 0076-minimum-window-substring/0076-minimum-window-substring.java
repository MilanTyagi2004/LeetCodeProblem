class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        if (t.length() > n) return "";

        HashMap<Character, Integer> mpp = new HashMap<>();

        for (char ch : t.toCharArray()) {
            mpp.put(ch, mpp.getOrDefault(ch, 0) + 1);
        }

        int i = 0, j = 0;
        int requiredCount = t.length();
        int size = Integer.MAX_VALUE;
        int start_i = 0;

        while (j < n) {
            char ch = s.charAt(j);

            if (mpp.containsKey(ch)) {
                if (mpp.get(ch) > 0) {
                    requiredCount--;
                }
                mpp.put(ch, mpp.get(ch) - 1);
            }

            while (requiredCount == 0) {
                int curr = j - i + 1;

                if (curr < size) {
                    size = curr;
                    start_i = i;
                }

                char leftChar = s.charAt(i);

                if (mpp.containsKey(leftChar)) {
                    mpp.put(leftChar, mpp.get(leftChar) + 1);

                    if (mpp.get(leftChar) > 0) {
                        requiredCount++;
                    }
                }

                i++;
            }
            j++;
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start_i, start_i + size);
    }
}