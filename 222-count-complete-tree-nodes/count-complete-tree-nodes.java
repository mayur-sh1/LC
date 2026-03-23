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
    public int countNodes(TreeNode root) {
        int count[]=new int[1];

        preOrder(root,count);

        return count[0];
    }
    public void preOrder(TreeNode root,int count[]){
        if(root==null) return ;

        count[0]++;
        preOrder(root.left,count);
        preOrder(root.right,count);
    }
}