class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        StringBuilder sb=new StringBuilder();

        solve(ans,sb,n);

        return ans;
    }
    public void solve(List<String> ans,StringBuilder sb,int n){
        if(sb.length()==2*n){
            if(isValid(sb)) ans.add(sb.toString());
            return;
        }

        sb.append("(");
        solve(ans,sb,n);
        sb.deleteCharAt(sb.length()-1);
        sb.append(")");
        solve(ans,sb,n);
        sb.deleteCharAt(sb.length()-1);
        
    }
    public boolean isValid(StringBuilder sb){
        int counter=0;
        for(char ch:sb.toString().toCharArray()){
            if(ch=='(') counter++;
            else counter--;

            if(counter<0) return false;
        }
        return counter==0;
    }
}