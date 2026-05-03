class Solution {
    public int rotatedDigits(int n) {
        Map<Integer,Integer> mpp = new HashMap<>();
        mpp.put(0,0);
        mpp.put(1,1);
        mpp.put(8,8);
        mpp.put(2,5);
        mpp.put(5,2);
        mpp.put(6,9);
        mpp.put(9,6);

        int cnt = 0;

        for(int i = 1; i <= n; i++){
            boolean valid = true;
            boolean changed = false;

            int num = i;

            while(num != 0) {
                int dig = num % 10;
                Integer val = mpp.get(dig);

                if (val == null) { 
                    valid = false;
                    break;
                }

                if (val != dig) { 
                    changed = true;
                }

                num /= 10;
            }

            if (valid && changed) cnt++;
        }

        return cnt;
    }
}