class Solution {

    int dp[]=new int[10001];

    public int numSquares(int n) {
        Arrays.fill(dp,-1);
        return helper(n);
    }
    int helper(int n){
        if(n==0) return 0;

        if(dp[n]!=-1) return dp[n];

        int minCount=Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++){
            int res=1+helper(n-i*i);
            minCount=Math.min(minCount,res);
        }

        return dp[n]=minCount;
    }
}
// Time: O(n * √n)