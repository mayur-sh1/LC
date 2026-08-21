class Solution {
    int MOD = 1_000_000_007;

    int[][] moves = {
        {4, 6},       // 0
        {6, 8},       // 1
        {7, 9},       // 2
        {4, 8},       // 3
        {0, 3, 9},    // 4
        {},           // 5
        {0, 1, 7},    // 6
        {2, 6},       // 7
        {1, 3},       // 8
        {2, 4}        // 9
    };

    long[][] dp;

    public int knightDialer(int n) {
        dp = new long[10][n + 1];

        // -1 means not calculated yet
        for (int i = 0; i < 10; i++) {
            Arrays.fill(dp[i], -1);
        }

        long ans = 0;

        for (int digit = 0; digit <= 9; digit++) {
            ans += solve(digit, n);
            ans %= MOD;
        }

        return (int) ans;
    }

    long solve(int digit, int remaining) {

        if (remaining == 1) {
            return 1;
        }

        if (dp[digit][remaining] != -1) {
            return dp[digit][remaining];
        }

        long count = 0;

        for (int next : moves[digit]) {
            count += solve(next, remaining - 1);
            count %= MOD;
        }

        return dp[digit][remaining] = count;
    }
}

// for n=1  ans is 10