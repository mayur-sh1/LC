class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();

        boolean pastIsNull=false;

        q.offer(root);

        while(!q.isEmpty()){
            int size=q.size();

            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                
                if(node==null){
                    pastIsNull=true;
                }
                else{
                    if(pastIsNull) return false;
                    
                    q.offer(node.left);
                    q.offer(node.right);

                }
            }
        }
        return true;
    }
}