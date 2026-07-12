class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int cnt  =0;
        int [] array = arr.clone();
        Arrays.sort(arr);
        Map<Integer,Integer>mpp  = new HashMap<>();
        for(int i=1;i<=arr.length;i++){
            if(!mpp.containsKey(arr[i-1])){
                cnt++;
                mpp.put(arr[i-1],cnt);
            }
        }
        int [] newArr = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            newArr[i] = mpp.get(array[i]);
        }
        return newArr;
    }
}