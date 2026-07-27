class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);

        int n=nums.length,m=queries.length;

        int prefix[]=new int [n];
        prefix[0]=nums[0];
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }

        int [] ans=new int[m];
        for(int i=0;i<m;i++){
            int querySum=queries[i];
            ans[i]=binarySearch(prefix,querySum);
        }
        return ans;
    }
    int binarySearch(int[] prefix,int querySum){
        int left=0,right=prefix.length-1;
        int count=0;

        while(left<=right){
            int mid=left+(right-left)/2;
            if(prefix[mid]<=querySum){
                count=mid+1;
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return count;
    }
}