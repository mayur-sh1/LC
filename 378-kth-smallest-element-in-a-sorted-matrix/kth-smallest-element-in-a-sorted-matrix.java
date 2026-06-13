class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());

        for(int [] a:matrix){
            for(int ele:a) pq.add(ele);
        }

        while(pq.size()>k) pq.poll();

        return pq.poll();
    }
}