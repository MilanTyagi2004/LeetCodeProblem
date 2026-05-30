class Solution {
    public String reverseWords(String s) {
        s=  s.trim();
        String []arr = s.split("\\s+");
        int i=0;
        int j = arr.length-1;
        while(i<=j){
            String t = arr[i];
            arr[i] = arr[j];
            arr[j] = t; 
            i++;
            j--;
        }
        StringBuilder sb =new StringBuilder();
        for(int  k=0;k<arr.length;k++){
            sb.append(arr[k]);
            if(k<arr.length-1 && !arr[k].equals(" ")){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}