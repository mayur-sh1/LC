class Solution {
    long mod = 1_000_000_007;
    public int countGoodNumbers(long n) {
        long evenIndices = (n + 1) / 2;
        long oddIndices = n / 2;

        long ans = (findPower(5, evenIndices) * findPower(4, oddIndices)) % mod;

        return (int) ans;
    }
    public long findPower(long x,long n){
        x=x%mod;
        if(n==0) return 1;
        if(n<0) return findPower(1/x,-n);
        if(n%2==0) return findPower((x*x)%mod,n/2);
        else return x*findPower((x*x)%mod,(n-1)/2)%mod;
    }
}