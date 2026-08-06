class Solution {
    int dp[]=new int[101];

    public int numDecodings(String s) {
        Arrays.fill(dp,-1);

        return helper(0,s,s.length());
    }
    int helper(int i,String s,int n){

        if(i==n) return dp[i]=1;// one valid split done
        
        if(dp[i]!=-1) return dp[i];

        if(s.charAt(i)=='0') return dp[i]=0;// no need to split

        int takeith=helper(i+1,s,n);
        int takeiAi1th=0;
        if(i+1<n){
            if(s.charAt(i)=='1' || s.charAt(i)=='2' && s.charAt(i+1)<='6'){
                takeiAi1th=helper(i+2,s,n);
            }
        }

        return dp[i]=takeith+takeiAi1th;
    }
}
// Complexity
// Time: O(n) (each index is solved once)
// Space: O(n) (DP array + recursion stack)