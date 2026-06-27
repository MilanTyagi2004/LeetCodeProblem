class Solution {

    void helper(TreeNode root, HashMap<Integer, Integer> map) {
        if (root == null) return;

        map.put(root.val, map.getOrDefault(root.val, 0) + 1);

        helper(root.left, map);
        helper(root.right, map);
    }

    public int[] findMode(TreeNode root) {

        HashMap<Integer, Integer> map = new HashMap<>();

        helper(root, map);

        int maxFreq = 0;

        for (int freq : map.values()) {
            maxFreq = Math.max(maxFreq, freq);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxFreq) {
                ans.add(entry.getKey());
            }
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}