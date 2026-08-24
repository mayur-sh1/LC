class Solution {
    Integer[][] dp;
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;

        dp=new Integer[n][n+1];
        return solve(0,-1,nums);
    }
    int solve(int index,int prev,int[] nums){
        if(index==nums.length) return 0;

        if(dp[index][prev+1]!=null) return dp[index][prev+1];

        int skip=solve(index+1,prev,nums);
        
        int take=0;
        if(prev==-1 || nums[index]>nums[prev]){
            take=1+solve(index+1,index,nums);
        }

        return dp[index][prev+1]=Math.max(skip,take);
    }
}