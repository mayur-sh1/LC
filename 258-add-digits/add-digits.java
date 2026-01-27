class Solution {
    public int addDigits(int num) {
        return helper(num);
    }
    public int helper(int n){
        if(n<10) return n;

        int sum=0;
        while(n!=0){
            sum=sum+(n%10);
            n=n/10;
        }
        return helper(sum);
    }
}