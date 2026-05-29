class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Integer.MIN_VALUE;
        for(int i:candies){
            max = Math.max(max,i);
        }
        List<Boolean>al  =new ArrayList<>();
        for(int i:candies){
            if(i+extraCandies>=max){
                al.add(true);
            }else{
                al.add(false);
            }
        }
        return al;
    }
}