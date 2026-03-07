class Solution {
    public List<List<Integer>> combine(int n, int k) {
        int nums[]=new int[n];
        for(int i=0;i<n;i++) nums[i]=i+1;

        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> sub=new ArrayList<>();
        boolean visited[]=new boolean[n];

        helper(0,ans,sub,visited,nums,n,k);

        return ans;
    }
    public void helper(int index,List<List<Integer>> ans,List<Integer> sub,boolean visited[],int nums[],int n,int k){
        if(sub.size()==k){
            ans.add(new ArrayList<>(sub));
            return ;

        }
        
        for(int i=index;i<n;i++){
            if(!visited[i]){
                sub.add(nums[i]);
                visited[i]=true;

                helper(i+1,ans,sub,visited,nums,n,k);

                sub.remove(sub.size()-1);
                visited[i]=false;
            }
        }
    
    }
}