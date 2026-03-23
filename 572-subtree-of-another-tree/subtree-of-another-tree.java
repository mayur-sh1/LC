class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;

        // check current node
        if (root.val == subRoot.val && isSameTree(root, subRoot)) {
            return true;
        }

        // check in left or right subtree
        return isSubtree(root.left, subRoot) || 
               isSubtree(root.right, subRoot);
    }

    public TreeNode inOrder(TreeNode root,int val){
        if(root==null) return null;
        if(root.val==val) return root;

        TreeNode left=inOrder(root.left,val);
        if(left!=null) return left;
        
        return inOrder(root.right,val);
    }

    public boolean isSameTree(TreeNode p,TreeNode q){
        if(p==null && q==null) return true;

        if(p==null || q==null || p.val!=q.val) return false;

        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}