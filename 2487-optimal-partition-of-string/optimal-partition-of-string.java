class Solution {
    public int partitionString(String s) {
        int n=s.length(); 
        int i=0;
        int count=0;
        while(i<n){
            int temp=i;

            HashSet<Character> set=new HashSet<>();
            while(temp<n && set.contains(s.charAt(temp))==false){
                set.add(s.charAt(temp));
                temp++;
            }
            count++;

            i=temp;
        }
        return count;
    }
}