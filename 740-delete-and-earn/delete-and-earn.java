class Solution {
    int[] dp;
    public int deleteAndEarn(int[] nums) {
        int max=Arrays.stream(nums).max().getAsInt();
        
        int[] points=new int[max+1];

        dp=new int[max+1];
        Arrays.fill(dp,-1);

        for(int num:nums){
            points[num]+=num;
        }

        // starting from point 1
        return solve(1,points);
    }
    int solve(int num,int[] points){
        if(num>=points.length) return 0;

        if(dp[num]!=-1) return dp[num];

        int take=points[num]+solve(num+2,points);
        int skip=solve(num+1,points);

        return dp[num]=Math.max(take,skip);
    }
}