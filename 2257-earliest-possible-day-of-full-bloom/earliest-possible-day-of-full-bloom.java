class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n=growTime.length;
        
        Integer[] index=new Integer[n];
        for(int i=0;i<n;i++) index[i]=i;
        
        Arrays.sort(index,(a,b)->growTime[b]-growTime[a]);

        int maxBloomTime=0;
        int prevPlantTime=0;

        for(int i:index){
            prevPlantTime+=plantTime[i];// adding currrent plant time

            int currentBloomTime=prevPlantTime+growTime[i];

            maxBloomTime=Math.max(maxBloomTime,+currentBloomTime);
        }

        return maxBloomTime;
    }
}