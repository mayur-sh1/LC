class Solution {
    long mod = 1_000_000_007;

    public int minNonZeroProduct(int p) {
        long max = (1L << p) - 1;

        long ans = (pow(max - 1, (max - 1) / 2) % mod * (max % mod)) % mod;

        return (int) ans;
    }

    public long pow(long x, long n) {
        x = x % mod; // keep x small

        if (n == 0) return 1;
        if (n < 0) return pow(1 / x, -n);

        if (n % 2 == 0)
            return pow((x % mod * x % mod) % mod, n / 2);
        else
            return (x % mod * pow((x % mod * x % mod) % mod, (n - 1) / 2)) % mod;
    }
}