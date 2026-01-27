class Solution {
    public boolean isPerfectSquare(int num) {
        int max=(int)Math.sqrt(num);

        int i=1,j=max;
        while(i<=j){
            int mid=i+(j-i)/2;
            int sqr=mid*mid;
            if(sqr==num) return true;
            else if(sqr<num) i=mid+1;
            else j=mid-1;
        }
        return false;
    }
}