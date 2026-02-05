class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n=nums.length;
        int ans[]=new int[n];

        for(int i=0;i<n;i++){
            int next=nextIndex(i,nums[i],nums);
            ans[i]=nums[next];
        }   
        return ans;
    }
    public int nextIndex(int curr,int ele,int[] nums){
        int n=nums.length;
        int next=(curr+ele)%n;

        if(next<0) next+=n;

        return  next;
        
    }
}