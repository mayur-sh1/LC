class Solution {
    List<String>[][] dp;

    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n=words.length;
        dp=new ArrayList[n][n+1];
        return solve(0,-1,words,groups);
    }
    List<String> solve(int index,int prev,String[] words, int[] groups){
        if(index==words.length){
            return new ArrayList<>();
        }

        if(dp[index][prev+1]!=null) return dp[index][prev+1];
        
        List<String> skip=solve(index+1,prev,words,groups);
        List<String> take=new ArrayList<>();
        
        if(prev==-1 || (groups[prev]!=groups[index] &&  hammingDistance(words[index],words[prev])==1)){
            take.add(words[index]);

            List<String> next=solve(index+1,index,words,groups);

            take.addAll(next);
        }
        
        return dp[index][prev+1]=take.size()>skip.size()?take:skip;
    }
    int hammingDistance(String word1,String word2){
        int dis=0;

        if(word1.length()!=word2.length()) return 0;

        for(int i=0;i<word1.length();i++){
            if(word1.charAt(i)!=word2.charAt(i)) dis++;
        }

        return dis;
    }
}