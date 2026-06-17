class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);

        Map<Integer,Integer> map=new HashMap<>();// to store frequency of each char 

        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            int key=e.getKey();
            int freq=e.getValue();

            pq.add(new int[]{key,freq});
            if(pq.size()>k) pq.poll();
        }
        int[] ans=new int[k];
        int i=0;
        while(!pq.isEmpty()){
            int[] pair=pq.poll();
            ans[i]=pair[0];
            i++;
        }
        return ans;

    }
}