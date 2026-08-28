class Solution {
    Integer[][] dp;
    public int minDistance(String word1, String word2) {
        dp=new Integer[word1.length()][word2.length()];
        return solve(0,0,word1,word2);

    }

    int solve(int i,int j,String word1,String word2){
        if(i==word1.length()){
            return word2.length()-j; // all remaining characters of word2 must be delete
        }

        if(j==word2.length()){
            return word1.length()-i;
        }
        
        if(dp[i][j]!=null) return dp[i][j];

        if(word1.charAt(i)==word2.charAt(j)){
            return solve(i+1,j+1,word1,word2);
        }

        int deleteFromWord1=1+solve(i+1,j,word1,word2);
        int deleteFromWord2=1+solve(i,j+1,word1,word2);

        return dp[i][j]=Math.min(deleteFromWord1,deleteFromWord2);
    
    }
}