class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n=nums.length;
        int left=0,maxSize=0;
        Deque<Integer> minDq=new ArrayDeque<>();
        Deque<Integer> maxDq=new ArrayDeque<>();

        for(int right=0;right<n;right++){
            // MAX DEQUE
            while(!maxDq.isEmpty() && nums[maxDq.peekLast()]<nums[right]){
                maxDq.pollLast();
            }
            maxDq.addLast(right);
            // MIN DEQUE
            while(!minDq.isEmpty() && nums[minDq.peekLast()]>nums[right]){
                minDq.pollLast();
            }
            minDq.addLast(right);

            // shrink window
            while(nums[maxDq.peekFirst()]-nums[minDq.peekFirst()] > limit){
                if(maxDq.peekFirst()==left) maxDq.pollFirst();
                if(minDq.peekFirst()==left) minDq.pollFirst();

                left++;
            }

            int windowSize=right-left+1;
            maxSize=Math.max(maxSize,windowSize);
        }
        return maxSize;
    }
}