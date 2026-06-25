class Solution {
    public String minRemoveToMakeValid(String s) {
        int n=s.length();

        //storing indexes of opening brackets
        Stack<Integer> st=new Stack<>();

        Set<Integer> removeIndexes=new HashSet<>();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);

            if(ch=='(') st.push(i);
            else if(ch==')') {
                if(st.isEmpty()) removeIndexes.add(i);
                else st.pop();
            }
        }

        while(!st.isEmpty()){
            removeIndexes.add(st.pop());
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            if(removeIndexes.contains(i)) continue;
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}