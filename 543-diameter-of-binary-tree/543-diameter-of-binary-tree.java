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
    static int getDepth(TreeNode node)
    {
        if(node==null) return 0;
        return Math.max(getDepth(node.left), getDepth(node.right))+1;
    }
    static int max(int a, int b, int c)
    {
        return a>b ? a>c ? a : c : b>c ? b :c;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root.left==null && root.right==null) return 0;
        if(root.left==null) return getDepth(root.right);
        if(root.right==null) return getDepth(root.left);
        int path= getDepth(root.left)+getDepth(root.right);
        return max(path, diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right));
    }
}