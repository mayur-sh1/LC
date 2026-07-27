class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        for (int num1 : arr1) {
            boolean isClose = false; // track if any element in arr2 is close
            for (int num2 : arr2) {
                if (Math.abs(num1 - num2) <= d) {
                    isClose = true;
                    break; // no need to check further, already disqualified
                }
            }
            if (!isClose) {
                count++; // only count if NOT close to anything in arr2
            }
        }
        return count;
    }
}