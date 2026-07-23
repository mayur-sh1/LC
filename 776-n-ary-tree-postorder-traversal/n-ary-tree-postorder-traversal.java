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
}
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> postOrder=new ArrayList<>();
        if(root==null) return postOrder;

        helper(root,postOrder);

        return postOrder; 
    }
    void helper(Node root, List<Integer> postOrder){
        if(root==null) return ;

        for(Node child:root.children){
            helper(child,postOrder);
        }

        postOrder.add(root.val);

    }
}