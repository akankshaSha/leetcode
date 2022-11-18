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
    boolean check(TreeNode left, TreeNode right)
    {
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        if(left.val != right.val) return false;
        boolean cis = check(left.left, right.right);
        boolean trans = check(left.right, right.left);
        return cis && trans;
    }
    public boolean isSymmetric(TreeNode root) {
        TreeNode left = root.left; 
        TreeNode right = root.right;
        return check(left, right);
    }
}