class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        
        int n=nums.length,m=queries.length;

        int [] ans=new int[m];
        for(int i=0;i<m;i++){
            
            int querySum=queries[i];
            
            int sum=0,count=0;
            for(int num:nums){
                if(num<=querySum && sum+num<=querySum){
                    count++;
                    sum+=num;
                }
            }
            
            ans[i]=count;
        }
        return ans;
    }
}