class Solution {
    public int findGCD(int[] nums) {
        int max=Arrays.stream(nums).max().getAsInt();
        int min=Arrays.stream(nums).min().getAsInt();

        return gcd(max,min);
    }
    int gcd(int a,int b){
        return b==0?a:gcd(b,a%b);
    }
}