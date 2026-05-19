class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {

        PriorityQueue<Integer> left_max_heap =
                new PriorityQueue<>(Collections.reverseOrder());

        PriorityQueue<Integer> right_min_heap =
                new PriorityQueue<>();


        // first k elements
        for (int i = 0; i < k; i++) {

            if (left_max_heap.isEmpty() ||
                    nums[i] <= left_max_heap.peek()) {
                left_max_heap.add(nums[i]);
            } else {
                right_min_heap.add(nums[i]);
            }

            // balancing
            if (left_max_heap.size() - right_min_heap.size() > 1) {
                right_min_heap.add(left_max_heap.poll());
            }
            else if (left_max_heap.size() < right_min_heap.size()) {
                left_max_heap.add(right_min_heap.poll());
            }
        }

        int n = nums.length;
        double[] ans = new double[n - k + 1];

        Map<Integer,Integer> map = new HashMap<>();

        int j = 0;

        ans[j] = (k % 2 == 1)
                ? left_max_heap.peek()
                : ((double)left_max_heap.peek()
                + right_min_heap.peek()) / 2.0;


        for (int i = k; i < n; i++) {

            int numAdd = nums[i];
            int numRemove = nums[i-k];

            // mark for lazy deletion
            map.put(numRemove,
                    map.getOrDefault(numRemove,0)+1);

            int counter = 0;

            // add new number
            if (numAdd <= left_max_heap.peek()) {
                left_max_heap.add(numAdd);
                counter += 1;
            }
            else {
                right_min_heap.add(numAdd); // fixed
                counter -= 1;
            }

            // removed number belongs to?
            if (numRemove <= left_max_heap.peek())
                counter -= 1;
            else
                counter += 1;


            // rebalance
            if (counter > 0)
                right_min_heap.add(left_max_heap.poll());

            else if (counter < 0)
                left_max_heap.add(right_min_heap.poll());


            // lazy remove from left heap
            while (!left_max_heap.isEmpty() &&
                    map.getOrDefault(
                            left_max_heap.peek(),0) > 0) {

                int x = left_max_heap.poll();
                map.put(x,map.get(x)-1);
            }

            // lazy remove from right heap
            while (!right_min_heap.isEmpty() &&
                    map.getOrDefault(
                            right_min_heap.peek(),0) > 0) {

                int x = right_min_heap.poll();
                map.put(x,map.get(x)-1);
            }


            j++;

            ans[j] = (k % 2 == 1)
                    ? left_max_heap.peek()
                    : ((double)left_max_heap.peek()
                    + right_min_heap.peek()) / 2.0;
        }

        return ans;
    }
}