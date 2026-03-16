class Solution {
    public int minCost(String colors, int[] neededTime) {
        int cost=0;
        int n=colors.length();
        for(int i=0;i<n-1;i+=1){
            if(colors.charAt(i)==colors.charAt(i+1)){
                cost+=Math.min(neededTime[i],neededTime[i+1]);

                // keep the larger time for next comparisons
                neededTime[i + 1] = Math.max(neededTime[i], neededTime[i + 1]);
            }
        }
        return cost;
    }
}