class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans=new ArrayList<>();
        for(int i=left;i<=right;i++){
            if(isSelfDividing(i)) ans.add(i);
        }
        return ans;
    }
    public boolean isSelfDividing(int n){
        int temp=n;
        while(temp>0){
            int digit=temp%10;
            if(digit==0 || n%digit!=0) return false;
            temp=temp/10;
        }
        return true;
    }
}