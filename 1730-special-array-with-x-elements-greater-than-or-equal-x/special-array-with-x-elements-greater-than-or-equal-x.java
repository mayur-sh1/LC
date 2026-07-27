class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);

        int n=nums.length;
        int left=0,right=n-1;   
        int ans=-1;

        while(left<=right){
            int mid=left+(right-left)/2;
            int numsFromMid=n-mid;

            if(nums[mid]>=numsFromMid){
                ans=numsFromMid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }

        //verify
        int count=0;
        if(ans!=-1){
            for(int num:nums){
                if(num>=ans) count++;
            }
        }
        if(count!=ans) ans=-1;

        return ans;
    }
}