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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> leaf1=new ArrayList<>();
        ArrayList<Integer> leaf2=new ArrayList<>();

        findLeaf(root1,leaf1);
        findLeaf(root2,leaf2);

        if(leaf1.size()!=leaf2.size()) return false;

        for(int i=0;i<leaf1.size();i++){
            if (!leaf1.get(i).equals(leaf2.get(i))) return false; // FIX
        }
        return true;
    }
    public void findLeaf(TreeNode root,ArrayList<Integer> l){
        if(root==null) return;

        if(root.left==null && root.right==null) l.add(root.val);

        findLeaf(root.left,l);
        findLeaf(root.right,l);
    }
}