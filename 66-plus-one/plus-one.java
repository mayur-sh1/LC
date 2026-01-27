class Solution {
    public int[] plusOne(int[] digits) {
        int n=digits.length;
        int carry=1;
        int i;
        for(i=n-1;i>=0;i--){
            int sum=digits[i]+carry;
            if(sum<10) {
                digits[i]=sum;
                return digits;
            }
            else{
                // bcz we are adding only one
                digits[i]=0;
                carry=1;
            }
        }

        int ans[]=new int[n+1];
        ans[0]=carry;
        return ans;
    }
}