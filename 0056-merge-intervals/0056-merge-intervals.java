class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0], b[0]));
        // int [][] newArr = new int[][];
        ArrayList<int []> al = new ArrayList<>();
        int first = intervals[0][0];
        int second = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(second >=intervals[i][0]){
            second  = Math.max(second, intervals[i][1]);
            }else{
                al.add(new int[]{first,second});
                first = intervals[i][0];
                second = intervals[i][1];
            }
        }
        al.add(new int[]{first,second});
        return al.toArray(new int [al.size()][]);
    }
}