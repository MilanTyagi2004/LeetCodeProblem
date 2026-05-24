class Solution {
    public int[] limitOccurrences(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer>mpp = new HashMap<>();

       for(int i:nums){
        mpp.put(i,mpp.getOrDefault(i,0)+1);
       }
       ArrayList<Integer>al = new ArrayList<>();
       for(Map.Entry<Integer,Integer>entry:mpp.entrySet()){
        int key = entry.getKey();
        int val = entry.getValue();
        int t = k;
        if(val>k){
            while(t-->0){
                al.add(key);
            }
        }else{
            while(val-->0){
                al.add(key);
            }
        }
       }
       Collections.sort(al);
       int arr [] = new int[al.size()];
       for(int i=0;i<al.size();i++){
        arr[i] = al.get(i);
       }
       return arr;
    }
}