class Solution {
    public int totalWaviness(int num1, int num2) {
        
        int total =0;
        for(int x=num1;x<=num2;x++){
            String t = String.valueOf(x);
            if(t.length()<3){
                continue;
            }

            int localWave = 0;
            for(int i=1;i<t.length()-1;i++){
                int left  = t.charAt(i-1)-'0';
                int mid  = t.charAt(i)-'0';
                int right  = t.charAt(i+1)-'0';
                boolean peak = (mid>left&&mid>right);
                boolean valley = (mid<left&&mid<right);
                if(peak||valley){
                    localWave++;
                }
            }
            total += localWave;
        }
        return total;
    }
}