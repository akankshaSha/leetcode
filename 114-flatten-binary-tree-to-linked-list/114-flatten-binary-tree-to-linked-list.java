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
    public void flatten(TreeNode root) {
        if(root==null || (root.right==null && root.left==null)) return;
        if(root.left!=null)
        {
            TreeNode prevRight=root.right;
            root.right=root.left;
            root.left=null;
            
            TreeNode t=root;
            while(t.right!=null) t=t.right;
            t.right=prevRight;
        }
        flatten(root.right);
    }
}