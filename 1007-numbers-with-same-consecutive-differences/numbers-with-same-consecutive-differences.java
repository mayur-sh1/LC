class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        // fix 2: include 0 in digits array
        int nums[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            solve(nums, ans, i, n, k);
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    public void solve(int[] nums, ArrayList<Integer> ans, int currNum, int n, int k) {
        // fix 1: use log10 for digit count check
        if ((int)(Math.log10(currNum) + 1) == n) {
            ans.add(currNum);
            return;
        }

        int lastDigit = currNum % 10;

        // fix 3: i <= 9 to cover all 10 digits
        for (int i = 0; i <= 9; i++) {
            if (Math.abs(lastDigit - nums[i]) == k) {
                // fix 4: do not modify currNum, pass expression directly
                solve(nums, ans, currNum * 10 + nums[i], n, k);
            }
        }
    }
}