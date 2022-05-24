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
  
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder pathS = new StringBuilder();
        StringBuilder pathT = new StringBuilder();
        
        dfs(root, startValue, pathS);
        dfs(root, destValue, pathT);
        
        int i = pathS.length()-1;
        int j = pathT.length()-1;
        while (i >= 0 && j >= 0 && pathS.charAt(i) == pathT.charAt(j)) {
            i--;
            j--;
        }
        StringBuilder res = new StringBuilder();
        for (int m = i; m >= 0; m--) {
            res.append('U');
        }
        for (int m = j; m >= 0; m--) {
            res.append(pathT.charAt(m));
        }
        return res.toString();
    }
    
    private boolean dfs(TreeNode root, int target, StringBuilder path) {
        if (root == null) {
            return false;
        }
        if (root.val == target) {
            return true;
        }
        
        if (dfs(root.left, target, path)) {
            path.append('L');
        } else if (dfs(root.right, target, path)) {
            path.append('R');
        }
        return path.length()>0;
    }
}