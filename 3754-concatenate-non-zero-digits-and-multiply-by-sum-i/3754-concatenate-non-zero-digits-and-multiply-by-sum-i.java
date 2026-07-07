class Solution {
    public long sumAndMultiply(int n) {
        // with space complexity o(1) and time complexity o(n+m) for reversing and then computing the solution 
        if(n==0){
            return 0;
        }
        long rn = 0;
        while(n!=0){
            long dig = n%10;
            rn =rn*10 + dig;
            n/=10;
        }
        long sum =0;
        long num=0;
        while(rn!=0){
            long dig = rn%10;
            if(dig!=0){
                sum+=dig;
                num = num*10 +dig;
            }
            rn/=10;
        }
        return num*sum;
    }
}