/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        serializeHelper(root,sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append("null,");
            return;
        }

        sb.append(root.val+",");
        serializeHelper(root.left,sb);
        serializeHelper(root.right,sb);
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] s=data.split(",");
        Queue<String> queue=new LinkedList<>(Arrays.asList(s));
        return deserializeHelper(queue);
    }

    private TreeNode deserializeHelper(Queue<String> queue){
        String s=queue.poll();
        if(s.equals("null")) return null;

        TreeNode root=new TreeNode(Integer.parseInt(s));
        root.left=deserializeHelper(queue);
        root.right=deserializeHelper(queue);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));