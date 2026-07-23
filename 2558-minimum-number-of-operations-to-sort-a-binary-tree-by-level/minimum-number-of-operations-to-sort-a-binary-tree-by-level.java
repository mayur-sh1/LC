class Solution {
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();

        int count=0;
        if(root==null) return count;

        q.offer(root);

        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> subList=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                
                subList.add(node.val);

                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
            count+=minSwaps(subList);
        }
        return count;
    }
    int minSwaps(List<Integer> list){
        int n=list.size();
        // element , prevIndex
        int[][] arr=new int[n][2];

        for(int i=0;i<n;i++){
            arr[i][0]=list.get(i);
            arr[i][1]=i;
        }

        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        boolean visited[]=new boolean[n];

        int swaps=0;

        for(int i=0;i<n;i++){
            int cycle=0;

            if(visited[i] || arr[i][1]==i) continue;

            int j=i;
            while(!visited[j]){
                visited[j]=true;

                j=arr[j][1];

                cycle+=1;
            }
            swaps+=cycle-1;
        }
        return swaps;
    }
}