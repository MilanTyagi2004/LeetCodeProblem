class Solution {
    public int minimumDistance(int[] nums) {
        int []cp = nums;
        Map<Integer,int[]> track = new HashMap<>();
        int answer = Integer.MAX_VALUE;

        for(int i=0;i<cp.length;i++){
            int val = cp[i];

            track.putIfAbsent(val,new int[]{-1,-1,-1});

            int []pos = track.get(val);

            pos[0] = pos[1];
            pos[1] = pos[2];
            pos[2] = i;

            if(pos[0]!=-1){
                int dis = 2*(pos[2]-pos[0]);
                if(dis<answer)answer = dis;
            }
        }
        return answer==Integer.MAX_VALUE?-1:answer;
    }
}