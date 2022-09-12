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
    boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p!=null && q!=null && p.val==q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right)) return true;
        return false;
    }
    
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(isSameTree(root, subRoot)) return true;
        if(root==null) return false;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}