class Solution {
    public boolean judgeSquareSum(int c) {
        int sqrt=(int)Math.sqrt(c);

        int i=0,j=sqrt;
        while(i<=j){
            long sum = (long) i * i + (long) j * j;

            if(sum==c) return true;
            else if(sum>c) j--;
            else i++;
        }
        return false;
    }
}