class Solution {
    public long totalHours(int[] piles,int mid){
        long hours=0;
        for(int i=0;i<piles.length;i++){
            long ceilOfHour=piles[i]/mid + (piles[i]%mid==0?0:1);
            hours=hours+ceilOfHour;
        }
        return hours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        // becz it is the maximum speed with wich coco eat
        int maxx=Arrays.stream(piles).max().getAsInt();

        int low=1,high=maxx;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(totalHours(piles,mid)<=h){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;

    }
}