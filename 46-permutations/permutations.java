class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n=nums.length;
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> sub=new ArrayList<>();
        boolean[] visited=new boolean[n];
        helper(ans,sub,visited,nums,n);
        return ans;
    }

    public void helper(List<List<Integer>> ans,List<Integer> sub,boolean[] visited,int[] nums,int n){
        if(sub.size()==n){
            ans.add(new ArrayList<>(sub));
            return;
        }

        for(int i=0;i<n;i++){
            if(!visited[i]){
                sub.add(nums[i]);
                visited[i]=true;
                helper(ans,sub,visited,nums,n);
                sub.remove(sub.size()-1);
                visited[i]=false;
            }
        }
    }
}