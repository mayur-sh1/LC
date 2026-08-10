class Solution {
    public String countAndSay(int n) {
        StringBuilder sb=new StringBuilder("1");

        for (int i = 1; i < n; i++) {
            sb = compressString(sb);
        }

        return sb.toString();
    }
    StringBuilder compressString(StringBuilder sb){
        StringBuilder ans=new StringBuilder();

        char curr=sb.charAt(0);
        int count=1;

        for(int i=1;i<sb.length();i++){
            if(curr==sb.charAt(i)) count++;
            else {
                ans.append(count).append(curr);
                count=1;
                curr=sb.charAt(i);
            }
        }
        
        ans.append(count).append(curr);
        return ans;
    }   
}