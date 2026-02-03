class Solution {
    public boolean validPalindrome(String s) {
        
        int n=s.length(),i=0,j=n-1;

        int count=0;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                return isPallindrome(s,i+1,j) || isPallindrome(s,i,j-1);
            }
            i++;j--;

        }
        return true;
    }
    public boolean isPallindrome(String s,int i,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;j--;
        }
        return true;
    }
}