/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans =new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();

        if(root==null) return ans;

        q.add(root);

        while(!q.isEmpty()){
            int n=q.size();
            List<Integer> subList=new ArrayList<>();

            for(int i=0;i<n;i++){
                TreeNode node=q.poll();
                subList.add(node.val);

                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            ans.add(subList);

        }
        Collections.reverse(ans);
        return ans;

    }
}