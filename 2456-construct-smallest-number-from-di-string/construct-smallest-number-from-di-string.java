class Solution {
    public String smallestNumber(String pattern) {
        int n=pattern.length();
        boolean used[]=new boolean[10];
        StringBuilder result=new StringBuilder();
        backtrack(pattern,0,new int[n+1],used,result);

        return result.toString();
    }
    public boolean backtrack(String pattern,int index,int nums[],boolean[] used,StringBuilder result){
        if(index>pattern.length()){
            for(int i=0;i<nums.length;i++){
                result.append(nums[i]);
            }
            return true; // found smallest lexicographical number
        }

        for(int digit=1;digit<=9;digit++){
            if(!used[digit] && (index==0 || isValid(nums[index-1],digit,pattern.charAt(index-1)))){
                used[digit]=true;
                nums[index]=digit;
                if(backtrack(pattern,index+1,nums,used,result)) return true;
                nums[index]=0;
                used[digit]=false;
            }
        }
        return false;
    }
    public boolean isValid(int lastDigit,int currDigit,char condition){
        return (condition=='I' && lastDigit<currDigit) || (condition=='D' && lastDigit>currDigit);
    }
}