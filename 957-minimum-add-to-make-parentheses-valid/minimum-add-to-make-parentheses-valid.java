class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st=new Stack<>();
        int size=0,open=0;

       for(char ch:s.toCharArray()){
        if(ch=='(') size++; 
        else if(size>0){ // closing bracked k liye opne waala req hoga tabhi valid hoga 
            size--;
        }
        else open++; // yaha closing bracket aa gya but opening nhi h thats why we req opening
       }

       return size+open;
    }
}