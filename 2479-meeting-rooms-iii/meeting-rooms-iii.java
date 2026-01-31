class Solution {
    public int mostBooked(int n, int[][] meetings) {
        // sort by start time
        Arrays.sort(meetings,(a,b)->a[0]-b[0]);

        int roomCount[]=new int[n];

        PriorityQueue<Integer> availableRooms=new PriorityQueue<>();
        // initially all rooms are available
        for(int i=0;i<n;i++) availableRooms.add(i);

        //[endTime,index]
        PriorityQueue<long[]> occupiedRooms =new PriorityQueue<>((a, b) -> a[0] == b[0]
                                                                            ? Long.compare(a[1], b[1])
                                                                            : Long.compare(a[0], b[0]));


        for(int i=0;i<meetings.length;i++){
            int start=meetings[i][0];
            int end=meetings[i][1];
            long duration=end-start;

            while(!occupiedRooms.isEmpty() && occupiedRooms.peek()[0]<=start){
                long expired[]=occupiedRooms.poll();
                availableRooms.add((int)expired[1]);
            }

            if(!availableRooms.isEmpty()){
                int room=availableRooms.poll();
                roomCount[room]++;
                occupiedRooms.add(new long[]{end,room});
            }
            else{
                //meeting is delayed
                long[] minEnd=occupiedRooms.poll();
                minEnd[0]+=duration;
                roomCount[(int)minEnd[1]]++;
                occupiedRooms.add(new long[]{minEnd[0],minEnd[1]});
            }
        }

        int ans=0;
        for(int i=1;i<n;i++){
            if(roomCount[i]>roomCount[ans]) ans=i;
        }
        return ans;

    }
}