class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        if(n==1) return 0;

        int destination=n-1;
        int jumps=0;
        int coverage=0,lastJumpIndex=0;


        for(int i=0;i<n;i++){
            coverage=Math.max(coverage,i+nums[i]);

            if(i==lastJumpIndex){
                lastJumpIndex=coverage;
                jumps++;
                
                if(coverage>=destination) return jumps;
            }

        }
        return jumps;
    }
}