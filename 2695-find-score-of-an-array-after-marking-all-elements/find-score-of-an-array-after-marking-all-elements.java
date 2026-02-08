class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[1] == b[1]
                ? Integer.compare(a[0], b[0])
                : Integer.compare(a[1], b[1])
        );

        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{i, nums[i]});
        }

        long score = 0;   //  MUST be long

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int idx = cur[0];
            int val = cur[1];

            if (visited[idx]) continue;

            score += val;

            visited[idx] = true;
            if (idx - 1 >= 0) visited[idx - 1] = true;
            if (idx + 1 < n) visited[idx + 1] = true;
        }

        return score;
    }
}
