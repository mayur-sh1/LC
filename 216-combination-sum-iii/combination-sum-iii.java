class Solution {
    int nums[]={1,2,3,4,5,6,7,8,9};
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> sub=new ArrayList<>();

        int index=0;
        helper(ans,sub,index,0,k,n);

        return ans;

    }

    public void helper(List<List<Integer>> ans,List<Integer> sub,int index,int sum,int k,int n){
        if(sub.size()==k && sum==n){
            ans.add(new ArrayList<>(sub));
            return;
        }

        if(index>8 || sub.size() > k ||  sum>n) return;

        sub.add(nums[index]);
        sum+=nums[index];
        helper(ans,sub,index+1,sum,k,n);
        sub.remove(sub.size()-1);
        sum-=nums[index];
        helper(ans,sub,index+1,sum,k,n);
    }
}