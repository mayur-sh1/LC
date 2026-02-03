class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        
        // Step 1: frequency count
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Step 2: max heap based on frequency
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[1] - a[1]
        );

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                // impossible check
                if (freq[i] > (n + 1) / 2) return "";
                pq.offer(new int[]{i, freq[i]});
            }
        }

        StringBuilder sb = new StringBuilder();

        // Step 3: greedy pairing
        while (pq.size() >= 2) {
            int[] first = pq.poll();
            int[] second = pq.poll();

            sb.append((char) (first[0] + 'a'));
            sb.append((char) (second[0] + 'a'));

            if (--first[1] > 0) pq.offer(first);
            if (--second[1] > 0) pq.offer(second);
        }

        // Step 4: leftover character
        if (!pq.isEmpty()) {
            int[] last = pq.poll();
            if (last[1] > 1) return "";
            sb.append((char) (last[0] + 'a'));
        }

        return sb.toString();
    }
}
