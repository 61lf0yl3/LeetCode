/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeDFS(root, sb);
        return sb.deleteCharAt(sb.length()-1).toString();
    }
    
    private void serializeDFS(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append('N').append(',');
        } else {
            sb.append(root.val).append(',');
            serializeDFS(root.left, sb);
            serializeDFS(root.right, sb);
        }
    } 

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] splits = data.split(",");
        Queue<String> q = new LinkedList<>();
        for (String split : splits) {
            q.add(split);
        }
        
        return deserializeDFS(q);
    }
    
    public TreeNode deserializeDFS(Queue<String> q) {
        if (q.isEmpty()) {
            return null;
        }
        String poll = q.poll();
        if (poll.equals("N")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(poll));
        root.left = deserializeDFS(q);
        root.right =  deserializeDFS(q);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));