class Solution {
    public int mostBooked(int n, int[][] meetings) {

        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        long[] endTimes = new long[n];   // use long to avoid overflow
        int[] roomCount = new int[n];

        for (int i = 0; i < meetings.length; i++) {
            int start = meetings[i][0];
            int end = meetings[i][1];

            boolean roomFound = false;

            // try to find free room
            for (int j = 0; j < n; j++) {
                if (start >= endTimes[j]) {
                    endTimes[j] = end;
                    roomCount[j]++;
                    roomFound = true;
                    break;
                }
            }

            // delay meeting
            if (!roomFound) {
                long minEnd = Long.MAX_VALUE;
                int room = -1;

                for (int k = 0; k < n; k++) {
                    if (endTimes[k] < minEnd) {
                        minEnd = endTimes[k];
                        room = k;
                    }
                }

                long duration = end - start;
                endTimes[room] = minEnd + duration;
                roomCount[room]++;
            }
        }

        // find room with max meetings
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (roomCount[i] > roomCount[ans]) {
                ans = i;
            }
        }

        return ans;
    }
}
