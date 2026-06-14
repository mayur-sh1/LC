class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();

        if(nums1.length==0 || nums2.length==0 ||k==0) return ans;

        // sum, i (nums1 index), j (nums2 index)
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]      // min heap
        );

       // take first ele of nums1 with every element of nums2
        for(int i=0;i<Math.min(nums2.length,k);i++){
            pq.add(new int[]{
                nums1[0]+nums2[i],0,i
            });
        }

        while(k>0 && !pq.isEmpty()){
            int arr[]=pq.poll();
            int i=arr[1],j=arr[2];

            ans.add(Arrays.asList(nums1[i],nums2[j]));
            k--;

            if(i+1<nums1.length){
                pq.add(new int[]{
                    nums1[i+1]+nums2[j],i+1,j
                });
            }
        }

        return ans;
    }
}