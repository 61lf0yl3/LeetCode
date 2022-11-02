/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        while (!qu.isEmpty()) {
            TreeNode node = qu.poll();
            if (p.val < node.val && q.val < node.val) {
                qu.add(node.left);
            } else if (p.val > node.val && q.val > node.val) {
                qu.add(node.right);
            } else {
                return node;
            }
        }
        return null;
    }
}