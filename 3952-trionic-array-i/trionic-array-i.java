class Solution {
    public boolean isTrionic(int[] nums) {
        int n=nums.length;
        if(n<4) return false;

        int i=0;

        //strictly  increasing
        while(i<n-1){
            if(nums[i]<nums[i+1]) i++;
            else break;
        }

        int p=i;
        if(p==0) return false;// no increasing part
        
        //strictly  decreasing
        while(i<n-1){
            if(nums[i]>nums[i+1]) i++;
            else break;

        }
        int q=i;
        if(q==p) return false; // no decreasing part
        if(q==n-1) return false;
        //strictly increasing
        int r=i;
        while(i<n-1){
            if(nums[i]<nums[i+1]) i++;
            else break;
        } 

        return i==n-1 && i>r;


       
    }
}