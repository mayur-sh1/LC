class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n=nums.length;

        // ele,index
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            if(a[0]==b[0]) return a[1]-b[1];

            return a[0]-b[0];
        });
        for(int i=0;i<n;i++){
            pq.add(new int[]{nums[i],i});
        }

        while(k-->0){
            int arr[]=pq.poll();
            int val=arr[0],idx=arr[1];

            int newValue=val*multiplier;

            pq.add(new int[]{newValue,idx});
        }

        int res[]=new int[n];
        while(!pq.isEmpty()){
            int[] ele=pq.poll();
            res[ele[1]]=ele[0];
        }
        return res;
    }
}