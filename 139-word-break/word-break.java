class Solution {
    Boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict=new HashSet<>(wordDict);
        
        dp=new Boolean[s.length()];
        return helper(s,0,dict);
    }

    boolean helper(String s,int start,Set<String> dict){
        if(start==s.length()) return true;

        if(dp[start]!=null) return dp[start];

        for(int end=start+1;end<=s.length();end++){
            if(dict.contains(s.substring(start,end)) && helper(s,end,dict)){
                return dp[start]=true;
            }
        }
        return dp[start]=false;
    }
}