/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> preorder=new ArrayList<>();
        if(root==null) return preorder;

        helper(root,preorder);

        return preorder;
    }
    void helper(Node root,List<Integer> preorder){
        if(root==null) return ;
        preorder.add(root.val);

        for(Node child:root.children){
            helper(child,preorder);
        }
    }
}