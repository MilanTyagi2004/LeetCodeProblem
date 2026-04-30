class Solution {
    public int[][] merge(int[][] arr) {
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        int first = arr[0][0];
        int second=  arr[0][1];
        ArrayList<int []>al = new ArrayList<>();
        for(int i=1;i<arr.length;i++){
            if(second>=arr[i][0]){
                second = Math.max(second,arr[i][1]);
            }else{
            al.add(new int []{first,second});
            first = arr[i][0];
            second = arr[i][1];
            }
        }
        al.add(new int []{first,second});
        return al.toArray(new int[al.size()][]);
    }
}