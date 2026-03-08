class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> sub=new ArrayList<>();

        int index=0,sum=0;
        
        int n=candidates.length;
        
        helper(ans,sub,index,sum,candidates,target,n);

        return ans;

    }
    public void helper(List<List<Integer>> ans,List<Integer> sub,int index,int sum,int[] candidates,int target,int n){
        if(sum>target) return;
        if(sum==target){
            ans.add(new ArrayList<>(sub));
            return;
        }

        for(int i=index;i<n;i++){
            if(i>index && candidates[i]==candidates[i-1]) continue; // this prevents gen same combination
            
            sub.add(candidates[i]);
            sum+=candidates[i];
            helper(ans,sub,i+1,sum,candidates,target,n);

            sub.remove(sub.size()-1);
            sum-=candidates[i];
        }


    }
}