class Solution {
    public boolean rotateString(String s, String goal) {
        char [] arr=s.toCharArray();
        int n=  s.length();
        for(int k=0;k<n;k++){
            char temp = arr[0];
            for(int i=1;i<n;i++){
                arr[i-1] =arr[i];
            }
            arr[n-1] =temp;
            String str = new String(arr);
            if(str.equals(goal)){
                return true;
            }
        }
        return false;
    }
}