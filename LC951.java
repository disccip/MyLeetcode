// 951. Flip Equivalent Binary Trees

class LC951 {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(root1);
        queue2.offer(root2);
        while (!queue1.isEmpty() && !queue2.isEmpty())
        {
            TreeNode n1 = queue1.poll();
            TreeNode n2 = queue2.poll();
            if (n1 == null && n2 == null) continue;
            if (n1 == null || n2 == null) return false;
            if (n1.val != n2.val) return false;
            TreeNode left1 = n1.left, left2 = n2.left;
            if (left1 == null && left2 == null)
            {
                queue1.offer(n1.left);
                queue1.offer(n1.right);
                queue2.offer(n2.left);
                queue2.offer(n2.right);
            }
            else if (left1 == null || left2 == null)
            {
                queue1.offer(n1.left);
                queue1.offer(n1.right);
                queue2.offer(n2.right);
                queue2.offer(n2.left);
            }
            else if (left1.val == left2.val)
            {
                queue1.offer(n1.left);
                queue1.offer(n1.right);
                queue2.offer(n2.left);
                queue2.offer(n2.right);
            }
            else 
            {
                queue1.offer(n1.left);
                queue1.offer(n1.right);
                queue2.offer(n2.right);
                queue2.offer(n2.left);
            }
        }
        return queue1.isEmpty() && queue2.isEmpty() ? true : false;
    }
}