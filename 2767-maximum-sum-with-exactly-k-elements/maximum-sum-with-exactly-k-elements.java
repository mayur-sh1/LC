class Solution {
    public int maximizeSum(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue(Collections.reverseOrder());

        for(int n:nums) pq.add(n);

        int score=0;

        while(k-->0){
            int max=pq.poll();
            score+=max;
            pq.add(max+1);

        }
        return score;
    }
}