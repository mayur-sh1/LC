class Solution {

    int n;

    public int minSteps(int n) {

        if (n == 1) return 0;

        this.n = n;

        return solve(1, 0);
    }

    int solve(int currentA, int clip) {

        // Reached target
        if (currentA == n) {
            return 0;
        }

        // Went beyond target
        if (currentA > n) {
            return 1000000;
        }

        int copy = 1000000;
        int paste = 1000000;

        // COPY ALL
        if (currentA != clip) {
            copy = 1 + solve(currentA, currentA);
        }

        // PASTE
        if (clip > 0) {
            paste = 1 + solve(currentA + clip, clip);
        }

        return Math.min(copy, paste);
    }
}