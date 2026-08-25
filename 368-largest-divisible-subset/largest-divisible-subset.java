class Solution {
    List<Integer>[][] dp;
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        
        int n=nums.length;
        dp=new ArrayList[n][n+1];
        return solve(0,-1,nums);
    }
    List<Integer> solve(int index,int prev,int[] nums){
        if(index==nums.length){
            return new ArrayList<>();
        }

        if(dp[index][prev+1]!=null) return dp[index][prev+1];

        List<Integer> skip=solve(index+1,prev,nums);
        List<Integer> take=new ArrayList<>();
        if(prev==-1 || nums[index]%nums[prev]==0){
            take.add(nums[index]);
            List<Integer> next=solve(index+1,index,nums);
            take.addAll(next);
        }

        return dp[index][prev+1]=take.size()>skip.size()?take:skip;
    }
}