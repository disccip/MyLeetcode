// 426. Convert Binary Search Tree to Sorted Doubly Linked List

class LC426 {
    private Node prev;
    public Node treeToDoublyList(Node root) {
        if (root == null) return root;
        prev = new Node(-1, null, null);
        Node dummy = prev;
        process(root);
        prev.right = dummy.right;
        Node ret = dummy.right;
        ret.left = prev;
        return ret;
    }
    
    private void process(Node root)
    {
        if (root == null) return;
        process(root.left);
        root.left = prev;
        prev.right = root;
        prev = root;
        process(root.right);
    }
}