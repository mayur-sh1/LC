class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int n:arr) map.put(n,map.getOrDefault(n,0)+1);

        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int val:map.values()) pq.add(val);

        int ans=0,size=0,half=arr.length/2;
        while(size<half){
            size+=pq.poll();
            ans++;
        }
        return ans;
    }
}