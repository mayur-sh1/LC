class Solution {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();

        for(int num:nums){
            if(minHeap.contains(num)) continue;
            minHeap.add(num);

            if(minHeap.size()>3) minHeap.poll();
        }
        if(minHeap.size()==3) return minHeap.peek();

        // if size of minHeap is less than MAX ELEMENT is at bottom
        while(minHeap.size()>1){
            minHeap.poll();
        }
        return minHeap.peek();
    }
}