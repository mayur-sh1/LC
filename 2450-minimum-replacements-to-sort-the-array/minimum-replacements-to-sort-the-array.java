class Solution {
    public long minimumReplacement(int[] nums) {
        int n=nums.length;
        long operations=0;
        
        for(int i=n-2;i>=0;i--){
            if(nums[i]<=nums[i+1]) continue;

            int parts=nums[i]/nums[i+1];//  thi gives minimum number of parts in which number(nums[i]) can be broken
            if(nums[i]%nums[i+1]!=0) parts++;

            // if num[i] is 7 and nums[i+1] is 3 then optimally 7 can be broken into 3,4 and array becomes . .3,4,3,
            nums[i]=nums[i]/parts;

            operations+=parts-1;  
        }
        return operations;
    }
}