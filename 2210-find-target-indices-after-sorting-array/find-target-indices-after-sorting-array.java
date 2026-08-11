class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> ans=new ArrayList<>();
        
        int n=nums.length;
        int left=0,right=n-1;
        int first=-1;
        // first occurance
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                first=mid;
                right=mid-1;
            }else if(nums[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }


        // second occurance
        left=0;
        right=n-1;
        int second=-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                second=mid;
                left=mid+1;
            }
            else if(nums[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }

        if(first!=-1){
            while(first<=second){
                ans.add(first);
                first++;
            }
        }
        return ans;
    }
}