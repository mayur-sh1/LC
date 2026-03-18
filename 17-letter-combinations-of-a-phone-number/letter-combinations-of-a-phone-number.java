class Solution {
    HashMap<Integer,char[]> map=new HashMap<>();
    public Solution(){
        map.put(2,new char[]{'a','b','c'});
        map.put(3,new char[]{'d','e','f'});
        map.put(4,new char[]{'g','h','i'});
        map.put(5,new char[]{'j','k','l'});
        map.put(6,new char[]{'m','n','o'});
        map.put(7,new char[]{'p','q','r','s'});
        map.put(8,new char[]{'t','u','v'});
        map.put(9,new char[]{'w','x','y','z'});
    }


    public List<String> letterCombinations(String digits) {
        List<String> ans=new ArrayList<>();
        if(digits.length()==0) return ans;

        StringBuilder sb=new StringBuilder();

        helper(digits,0,ans,sb);

        return ans;
    }

    public void helper(String input,int index, List<String> ans,StringBuilder sb){
        if(index==input.length()){
            ans.add(sb.toString());
            return;
        }

        char alphabets[]=map.get(input.charAt(index)-'0');
        for(int i=0;i<alphabets.length;i++){
            sb.append(alphabets[i]);
            helper(input,index+1,ans,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}