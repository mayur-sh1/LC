class Solution {
    Integer dp[][];
    public int findLength(int[] nums1, int[] nums2) {
        int ans=0;
        dp=new Integer[nums1.length][nums2.length];

        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                ans=Math.max(ans,solve(i,j,nums1,nums2));
            }
        }
        return ans;
    }

    int solve(int i,int j,int[] nums1,int[] nums2){
        if(i==nums1.length || j==nums2.length) return 0;

        if(dp[i][j]!=null) return dp[i][j];

        if(nums1[i]==nums2[j]){
            return dp[i][j]=1+solve(i+1,j+1,nums1,nums2);
        }

        return dp[i][j]=0;
    }
}