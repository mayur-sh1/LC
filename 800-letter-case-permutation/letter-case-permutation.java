class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        
        helper(s,0,ans,sb);

        return ans;
    }
    public void helper(String s,int index,List<String> ans,StringBuilder sb){
        if(index==s.length()){
            ans.add(sb.toString());
            return;
        }

        char ch=s.charAt(index);

        if(Character.isDigit(ch)){
            sb.append(ch);
            helper(s,index+1,ans,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        else{
            // lowercase
            sb.append(Character.toLowerCase(ch));
            helper(s,index+1,ans,sb);
            sb.deleteCharAt(sb.length()-1);
            
            // uppercase
            sb.append(Character.toUpperCase(ch));
            helper(s,index+1,ans,sb);
            sb.deleteCharAt(sb.length()-1);
        }

    }
}