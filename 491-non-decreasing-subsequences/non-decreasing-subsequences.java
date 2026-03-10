class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> sub=new ArrayList<>();
        int index=0;
        solve(nums,ans,sub,index,nums.length);
        return ans;
    }
    public void solve(int[] nums,List<List<Integer>> ans,List<Integer> sub,int index,int n){
        if(sub.size()>=2 ){
            ans.add(new ArrayList<>(sub));
            // return;
        }
        
        Set<Integer> used=new HashSet<>();
        for(int i=index;i<n;i++){
            if(!used.contains(nums[i]) && (sub.isEmpty() || sub.get(sub.size()-1)<=nums[i])){
                sub.add(nums[i]);
                used.add(nums[i]);
                solve(nums,ans,sub,i+1,n);
                sub.remove(sub.size()-1);
            }
        }
       
        
    }
}