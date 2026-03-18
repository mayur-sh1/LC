class Solution {
    List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        int open=0,close=0;
        solve(ans,sb,open,close,n);

        return ans;
    }
    public void solve(List<String> ans,StringBuilder sb,int open,int close,int n){
        if(sb.length()==2*n){
            ans.add(sb.toString());
            return;
        }

        if(open<n){
            sb.append("(");
            solve(ans,sb,open+1,close,n);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close<open){
            sb.append(")");
            solve(ans,sb,open,close+1,n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}