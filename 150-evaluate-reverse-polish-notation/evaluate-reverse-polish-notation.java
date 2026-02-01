class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();
        for(String s:tokens){
            if(isOperand(s)){
                int b=st.pop();
                int a=st.pop();

                if(s.equals("+")) st.push(a+b);
                else if(s.equals("-")) st.push(a-b);
                else if(s.equals("*")) st.push(a*b);
                else st.push(a/b);
            }
            else st.push(Integer.parseInt(s));
        }
        return st.pop();
    }
    public boolean isOperand(String s){
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
}