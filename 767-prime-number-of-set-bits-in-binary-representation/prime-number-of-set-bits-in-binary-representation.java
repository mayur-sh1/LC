class Solution {
    public int countPrimeSetBits(int left, int right) {
        int count=0;
        for(int i=left;i<=right;i++){
            int bits=setBits(i);
            if(isPrime(bits)) count++;
        }
        return count;
    }
    public int setBits(int n){
        int ans=0;
        while(n!=0){
            n=n & (n-1);
            ans++;
        }
        return ans;
    }
    public boolean isPrime(int n){
        if(n<=1) return false;
        for(int i=2;i*i<=n;i++){
            if(n%i==0) return false;
        }
        return true;
    }

}