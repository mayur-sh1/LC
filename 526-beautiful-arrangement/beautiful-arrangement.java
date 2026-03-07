class Solution {
    public int countArrangement(int n) {
        int nums[]=new int[n];
        for(int i=0;i<n;i++) nums[i]=i+1;

        boolean visited[]=new boolean[n];
        int[] ans=new int[1];
        List<Integer> sub=new ArrayList<>();
        permutations(sub,nums,ans,visited,n);
        return ans[0];
    }
    public void permutations(List<Integer> sub,int[] nums,int[] ans,boolean[] visited,int n){
        if(sub.size()==n){
            ans[0]++;
            return;
        }

        int posi=sub.size()+1;
        for(int i=0;i<n;i++){
            if(!visited[i] && ((nums[i]%posi==0) ||(posi%nums[i]==0))){
                sub.add(nums[i]);
                visited[i]=true;

                permutations(sub,nums,ans,visited,n);

                sub.remove(sub.size()-1);
                visited[i]=false;
            }
        }
    }
}