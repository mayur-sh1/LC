class Solution {
    public String reverseString(String input){
        if(input==null) return "";
        
        return new StringBuilder(input).reverse().toString();
    } 
    public int longestPalindrome(String[] words) {
        HashMap<String,Integer> map=new HashMap<>();

        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);

        }

        int maxLength=0;
        boolean centerUsed=false;

        for(String word:words){
            String reverse=reverseString(word);

            if(!word.equals(reverse)){ // "ab","ba" ->"ab     ba"
                if(map.getOrDefault(word,0) > 0 && map.getOrDefault(reverse,0) > 0){
                    map.put(word,map.get(word)-1);
                    map.put(reverse,map.get(reverse)-1);
                    maxLength+=4;
                }
            }
            else{// "aa" -> "aa   aa"
                if(map.getOrDefault(word,0)>=2){
                    map.put(word,map.get(word)-2);
                    maxLength+=4;
                }
                else if(map.getOrDefault(word,0)==1 && centerUsed==false){
                    map.put(word,map.get(word)-1);

                    centerUsed=true;

                    maxLength+=2;
                }
            }
        }
        return maxLength;
    }
}