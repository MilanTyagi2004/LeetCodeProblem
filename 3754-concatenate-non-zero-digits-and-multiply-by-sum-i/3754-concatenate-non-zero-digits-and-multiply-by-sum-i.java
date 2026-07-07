class Solution {
    public long sumAndMultiply(int n) {
        if(n==0){
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        long rn = 0;
        while(n!=0){
            long dig = n%10;
            rn =rn*10 + dig;
            n/=10;
        }
        long sum =0;
        while(rn!=0){
            long dig = rn%10;
            if(dig!=0){
                sum+=dig;
                sb.append(String.valueOf(dig));
            }
            rn/=10;
        }
        long num = Long.parseLong(sb.toString());
        return num*sum;
    }
}