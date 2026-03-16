class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n=rocks.length;
        int[] diff=new int[n];

        for(int i=0;i<n;i++){
            diff[i]=Math.abs(capacity[i]-rocks[i]);
        }

        Integer[] indexes=new Integer[n];
        for(int i=0;i<n;i++) indexes[i]=i;

        Arrays.sort(indexes,(a,b)->diff[a]-diff[b]);

        int max=0;
        for(int index:indexes){
            int req=capacity[index]-rocks[index];

            if(additionalRocks!=0 && additionalRocks>=req){
                additionalRocks-=req;
                max++;
            }
        }
        return max;
    }
}