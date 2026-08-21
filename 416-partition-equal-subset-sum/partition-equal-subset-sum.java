class Solution {
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        
        int totalSum=0;
        for(int num:nums){
            totalSum+=num;
        }

        if(totalSum%2!=0) return false;
        int target=totalSum/2;

        dp=new Boolean[nums.length][target+1];

        return solve(0,target,nums);
    }
    boolean solve(int index,int target,int[] nums){

        if(target==0) return true;

        // No elements left
        if (index >= nums.length || target < 0) {
            return false;
        }

        if(dp[index][target]!=null) return dp[index][target];

        boolean take=solve(index+1,target-nums[index],nums);
        boolean notTake=solve(index+1,target,nums);

        return dp[index][target]=take || notTake;
    }
}