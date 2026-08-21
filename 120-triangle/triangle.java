class Solution {
    int[][] dp;
    public int minimumTotal(List<List<Integer>> triangle) {
       int n = triangle.size();

        dp = new int[n][n];
        for(int[] row:dp){
            Arrays.fill(row,Integer.MAX_VALUE);
        }

        return solve(0,0,triangle);
    }
    int solve(int row,int col,List<List<Integer>> triangle){
        if(row==triangle.size()-1) return triangle.get(row).get(col);

        if(dp[row][col]!=Integer.MAX_VALUE) return dp[row][col];

        int down=solve(row+1,col,triangle); 
        int diagonal=solve(row+1,col+1,triangle);

        return dp[row][col]=triangle.get(row).get(col)+Math.min(down,diagonal); 
    }
}