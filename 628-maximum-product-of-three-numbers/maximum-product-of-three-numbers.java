class Solution {
    public int maximumProduct(int[] nums) {
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            maxHeap.add(nums[i]);
            minHeap.add(nums[i]);
        }
        int max1=maxHeap.poll();
        int max2=maxHeap.poll();
        int max3=maxHeap.poll();

        int min1=minHeap.poll();
        int min2=minHeap.poll();

        return Math.max(max1*max2*max3,max1*min1*min2);
    }
}