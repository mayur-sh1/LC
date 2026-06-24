class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> st=new Stack<>();
        StringBuilder ans=new StringBuilder();
        StringBuilder sb=new StringBuilder();

        for(char ch:s.toCharArray()){
            if(ch=='('){
                st.push(ch);
                sb.append(ch);
            }
            else{
                st.pop();
                sb.append(ch);
            }

            if(st.isEmpty()){
                ans.append(sb.substring(1,sb.length()-1));
                sb=new StringBuilder();
            }
        }
        return ans.toString();
    }
}