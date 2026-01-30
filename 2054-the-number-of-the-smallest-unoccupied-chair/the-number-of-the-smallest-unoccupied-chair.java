import java.util.*;

class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;

        // store arrival, leave, friend index
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = times[i][0];
            arr[i][1] = times[i][1];
            arr[i][2] = i;
        }

        // sort by arrival time
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        // chairEnd[i] = when chair i becomes free
        int[] chairEnd = new int[n];
        Arrays.fill(chairEnd, -1);

        for (int i = 0; i < n; i++) {
            int arrival = arr[i][0];
            int leave = arr[i][1];
            int friend = arr[i][2];

            // find smallest free chair
            for (int chair = 0; chair < n; chair++) {
                if (chairEnd[chair] <= arrival) {
                    chairEnd[chair] = leave;

                    if (friend == targetFriend) {
                        return chair;
                    }
                    break;
                }
            }
        }

        return -1;
    }
}
