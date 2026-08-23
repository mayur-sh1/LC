class Solution {
    int ans=0;
    public int findTargetSumWays(int[] nums, int target) {
        // sum,index,
        solve(0,0,nums,target);
        return ans;
    }
    void solve(int sum,int index,int[] nums,int target){
        if(index==nums.length){
            if(sum==target){
                ans++;
            }
            return;
        }

        solve(sum+nums[index],index+1,nums,target);
        solve(sum-nums[index],index+1,nums,target);
    }
}