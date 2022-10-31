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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p ==null && q == null) {
            return true;
        }
        if (!check(p, q)) {
            return false;
        }
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(p);
        q2.add(q);
        while (!q1.isEmpty()) {
            int size1 = q1.size();
            int size2 = q2.size();
            
            if (size1 != size2) {
                return false;
            }
            for (int i = 0; i < size1; i++) {
                TreeNode node1 = q1.poll();
                TreeNode node2 = q2.poll();
                if (!check(node1, node2)) {
                    return false;
                }
                if (!check(node1.left, node2.left)) {
                    return false;
                }
                if (node1.left != null) {
                    q1.add(node1.left);
                    q2.add(node2.left);
                }
                if (!check(node1.right, node2.right)) {
                    return false;
                }
                if (node1.right != null) {
                    q1.add(node1.right);
                    q2.add(node2.right);
                }
            }
        }
        return q1.isEmpty() && q2.isEmpty();
    }
    
    private boolean check(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return node1.val == node2.val;
    }
}