class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;

        // int[] ele,listId,eleId
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);

        // adding first element of each row 
       for(int i=0;i<matrix.length;i++){
            pq.add(new int[]{matrix[i][0],
            i,0
            });
       }

       int counter=1;

       while(!pq.isEmpty()){
        int arr[]=pq.poll();

        int ele=arr[0];
        int listId=arr[1];
        int eleId=arr[2];

        if(counter==k) return ele;
        
        counter+=1;

        int nextElementId=eleId+1;
        if(nextElementId<n) {
            pq.add(new int[]{
                matrix[listId][nextElementId],
                listId,
                nextElementId
            });
        }

       }
       return -1;
    }
}