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
    int maxPath=Integer.MIN_VALUE;
    int dfs(TreeNode node)
    {
        if(node==null) return 0;
        int left=dfs(node.left);
        int right=dfs(node.right);
        int full=left+node.val+right;
        int half=Math.max(left, right)+node.val;
        maxPath=Math.max(maxPath, full);
        maxPath=Math.max(maxPath, half);
        maxPath=Math.max(maxPath, node.val);
        return Math.max(half, node.val);
    }
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxPath;
    }
}