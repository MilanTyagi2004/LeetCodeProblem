class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer>mpp = new HashMap<>();
        for(int i:nums){
            mpp.put(i,mpp.getOrDefault(i,0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->mpp.get(b) - mpp.get(a));

        pq.addAll(mpp.keySet());
        int arr [] = new int[k];
        for(int i=0;i<k;i++){
            arr[i] =pq.poll();
        }
        return arr;
    }
}