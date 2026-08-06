class Solution {
    int dp[]=new int[20];
    public int numTrees(int n) {
        Arrays.fill(dp,-1);

        return solve(n);
    }
    int solve(int n){
        if(n==0 || n==1) return 1;

        if(dp[n]!=-1) return dp[n];

        int ans=0;
        // make every number as root node
        for(int root=1;root<=n;root++){
            int left=solve(root-1);
            int right=solve(n-root);

            ans+=left*right;
        }
        return dp[n]=ans;
    }
}
// Time: O(n²)
// Space: O(n)

/*For n = 3:

Root = 1
Left = 0 nodes
Right = 2 nodes
Ways = 1 × 2 = 2

Root = 2
Left = 1 node
Right = 1 node
Ways = 1 × 1 = 1

Root = 3
Left = 2 nodes
Right = 0 nodes
Ways = 2 × 1 = 2

Total = 2 + 1 + 2 = 5*/