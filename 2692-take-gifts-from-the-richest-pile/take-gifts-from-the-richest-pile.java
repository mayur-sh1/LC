class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<gifts.length;i++){
            pq.add(gifts[i]);
        }

        while(k-->0){
            int n=pq.poll();
            int sqrt=(int)Math.sqrt(n);

            pq.add(sqrt);
        }

        long ans=0;
        while(!pq.isEmpty()){
            ans+=pq.poll();
        }
        return ans;
    }
}