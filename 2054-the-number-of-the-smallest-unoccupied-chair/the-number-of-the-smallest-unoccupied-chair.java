import java.util.*;

class Solution {
    public int smallestChair(int[][] times, int targetFriend) {

        int n = times.length;

        // arrival, leave, original index
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = times[i][0];
            arr[i][1] = times[i][1];
            arr[i][2] = i;
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();

        // endTime, chairIndex
        PriorityQueue<int[]> occupiedChairs =
                new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // initially all chairs are available
        for (int i = 0; i < n; i++) {
            availableChairs.add(i);
        }

        for (int i = 0; i < n; i++) {
            int arrival = arr[i][0];
            int leave = arr[i][1];
            int friend = arr[i][2];

            // free chairs whose time is over
            while (!occupiedChairs.isEmpty() &&
                   arrival >= occupiedChairs.peek()[0]) {

                int[] chair = occupiedChairs.poll();
                availableChairs.add(chair[1]);
            }

            int chair = availableChairs.poll();

            if (friend == targetFriend) {
                return chair;
            }

            occupiedChairs.add(new int[]{leave, chair});
        }

        return -1;
    }
}
