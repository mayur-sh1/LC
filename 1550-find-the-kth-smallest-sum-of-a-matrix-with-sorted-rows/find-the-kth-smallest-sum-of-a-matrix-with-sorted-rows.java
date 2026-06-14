import java.util.*;

class Solution {
    public int kthSmallest(int[][] mat, int k) {
        // Start with the first row as our initial candidate sums
        List<Integer> currentSums = new ArrayList<>();
        for (int val : mat[0]) {
            currentSums.add(val);
        }
        
        // Break early if the first row has more than k elements
        if (currentSums.size() > k) {
            currentSums = currentSums.subList(0, k);
        }

        // Merge subsequent rows one by one
        for (int i = 1; i < mat.length; i++) {
            // Max-Heap to keep track of the k smallest sums found so far for the current merge
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            
            for (int sum : currentSums) {
                for (int val : mat[i]) {
                    int nextSum = sum + val;
                    
                    if (maxHeap.size() < k) {
                        maxHeap.add(nextSum);
                    } else if (nextSum < maxHeap.peek()) {
                        maxHeap.poll(); // Remove the largest sum
                        maxHeap.add(nextSum); // Add the smaller alternative
                    } else {
                        // Since rows are sorted, if nextSum >= maxHeap.peek(),
                        // all subsequent elements in mat[i] will also be larger.
                        break;
                    }
                }
            }
            
            // Convert the max-heap back into a sorted list for the next row iteration
            currentSums = new ArrayList<>(maxHeap);
            Collections.sort(currentSums);
        }

        // The k-th smallest element will be at index k-1
        return currentSums.get(k - 1);
    }
}