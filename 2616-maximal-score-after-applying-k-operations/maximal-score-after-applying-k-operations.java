class Solution {
    public long maxKelements(int[] nums, int k) {
        int n=nums.length;

        // ele,index
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[0]-a[0]);
        for(int i=0;i<n;i++){
            pq.add(new int[]{nums[i],i});
        }

        long score=0;
        while(k-->0){
            int[] ele=pq.poll();
            int val=ele[0],idx=ele[1];

            score+=val;
            int ceilValue=(val+3-1)/3;
            nums[idx]=ceilValue;
            pq.add(new int[]{ceilValue,idx});
        }
        return score;
    }
}