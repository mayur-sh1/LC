class Solution {
    Boolean[][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()) return false;

        dp=new Boolean[s1.length()+1][s2.length()+1];
        return solve(0,0,s1,s2,s3);
    }
    boolean solve(int i,int j,String word1,String word2,String word3){
        int k=i+j;

        if(i==word1.length() && j==word2.length()){
            return true;
        }

        if(dp[i][j]!=null) return dp[i][j];

        boolean takeFromS1=false;
        boolean takeFromS2=false;

        if(i<word1.length() && word1.charAt(i)==word3.charAt(k)){
            takeFromS1=solve(i+1,j,word1,word2,word3);
        }
        if(j<word2.length() && word2.charAt(j)==word3.charAt(k)){
            takeFromS2=solve(i,j+1,word1,word2,word3);
        }

        return dp[i][j]=takeFromS1 || takeFromS2;
        
    }
}