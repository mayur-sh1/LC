class Solution {
    int n;
    public int beautifulSubsets(int[] nums, int k) {
        n=nums.length;
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> sub=new ArrayList<>();
        solve(ans,sub,nums,0,k);
        return ans.size();
    }
    public void solve(List<List<Integer>> ans,List<Integer> sub,int[] nums,int index,int k){
        if(sub.size()>=1){
            ans.add(new ArrayList<>(sub));
        }

        for(int i=index;i<n;i++){
            if(isBeautiful(nums[i],sub,k)){
                sub.add(nums[i]);
                solve(ans,sub,nums,i+1,k);
                sub.remove(sub.size()-1);
            }
        }
    }
    public boolean isBeautiful(int ele,List<Integer> sub,int k){
        for(int val:sub){
            if(Math.abs(val-ele)==k) return false;
        }
        return true;
    }
}