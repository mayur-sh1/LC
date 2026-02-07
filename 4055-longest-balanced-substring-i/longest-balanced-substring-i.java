class Solution {
    public int longestBalanced(String s) {
        int maxLen=0;

        for(int i=0;i<s.length();i++){
            int[] freq=new int[26];

            for(int j=i;j<s.length();j++){
                freq[s.charAt(j)-'a']++;

                if(isBalanced(freq)){
                    maxLen=Math.max(maxLen,j-i+1);
                }
            }
        }
        return maxLen;
    }
    public boolean isBalanced(int[] freq){
        int common=0;

        for(int i=0;i<26;i++){
            if(freq[i]==0) continue;
            
            if(common==0){
                common=freq[i];
            }
            else if(common!=freq[i]) return false;

        }
        return true;
    }
}