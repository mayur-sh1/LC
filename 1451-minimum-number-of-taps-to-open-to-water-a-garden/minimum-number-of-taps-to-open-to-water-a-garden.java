class Solution {
    public int minTaps(int n, int[] ranges) {
        int startEnd[]=new int[n+1];


        for(int i=0;i<=n;i++){
            int start=Math.max(0,i-ranges[i]);
            int end=Math.min(n,i+ranges[i]);

            startEnd[start]=Math.max(startEnd[start],end);
        }
        int taps=0;
        int curr_range=0;
        int max_range=0;

        for(int i=0;i<=n;i++){
            if(i>max_range) return -1;

            if(i>curr_range){
                taps++;
                curr_range=max_range;
            }
            max_range=Math.max(startEnd[i],max_range);

        }
        return taps;
    }
}