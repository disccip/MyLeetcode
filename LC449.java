// 449. Serialize and Deserialize BST ------- medium

public class LC449 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty())
        {
            TreeNode node = queue.poll();
            sb.append(sb.length() == 0 ? "" : "#");
            if (node == null) sb.append("null");
            else
            {
                sb.append(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split("#");
        if (strs[0].equals("null")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        int index = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty())
        {
            TreeNode node = queue.poll();
            String leftNode = strs[index++];
            String rightNode = strs[index++];
            TreeNode left = leftNode.equals("null") ? null : new TreeNode(Integer.parseInt(leftNode));
            TreeNode right = rightNode.equals("null") ? null : new TreeNode(Integer.parseInt(rightNode));
            node.left = left;
            node.right = right;
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return root;
    }
}