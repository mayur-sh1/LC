class Solution {
    public int minDeletions(String s) {

        int[] freq=new int[26];
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }


        int deletions=0;
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<26;i++){
            if(freq[i]==0) continue;

            while(set.contains(freq[i])){
                freq[i]-=1;
                deletions+=1;
            }
            if(freq[i]>0) set.add(freq[i]);
        }
        return deletions;
    }
}