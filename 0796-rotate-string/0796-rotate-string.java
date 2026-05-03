class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }

        StringBuilder sb  =new StringBuilder(s);
        sb.append(s);
        String str = sb.toString();
        return str.contains(goal);
    }
}