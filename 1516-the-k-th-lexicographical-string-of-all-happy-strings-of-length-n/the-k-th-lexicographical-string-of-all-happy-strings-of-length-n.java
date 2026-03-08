class Solution {
    public String getHappyString(int n, int k) {
        char chars[]={'a','b','c'};

        List<String> list=new ArrayList<>();
        StringBuilder sb=new StringBuilder();

        helper(chars,list,sb,n);

        //System.out.println(list);
        return k>list.size()?"":list.get(k-1);
    }
    public void helper(char chars[],List<String> list,StringBuilder sb,int n){
        if(sb.length()==n){
            list.add(sb.toString());
            return;
        }

        for(int i=0;i<3;i++){
            if(sb.length()==0){
                sb.append(chars[i]);
                helper(chars,list,sb,n);
                sb.deleteCharAt(sb.length()-1);
            }
            else{
                char prevChar=sb.charAt(sb.length()-1);
                if(prevChar!=chars[i]){
                    sb.append(chars[i]);
                    helper(chars,list,sb,n);
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }
    }
}