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
    ArrayList<Integer> list; 
    int k;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        list = new ArrayList<>();
        dfs(root);
        //System.out.println(list);
        return list.get(k-1);
    }
    
    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        if (list.size() < k) {
            dfs(node.left);
            list.add(node.val);
            dfs(node.right);
        } else {
            return;
        }
    }
}