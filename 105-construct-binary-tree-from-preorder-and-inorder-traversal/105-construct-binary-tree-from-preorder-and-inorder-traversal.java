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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder.length==0 || preorder.length==0) return null;
        int i=0;
        for(; i<inorder.length; i++)
            if(inorder[i]==preorder[0]) break;
        TreeNode node=new TreeNode(preorder[0]);
        int[] leftInorder=Arrays.copyOfRange(inorder, 0, i);
        int[] leftPreorder=Arrays.copyOfRange(preorder, 1, i+1);
        node.left=buildTree(leftPreorder, leftInorder);
        int[] rightInorder=Arrays.copyOfRange(inorder, i+1, inorder.length);
        int[] rightPreorder=Arrays.copyOfRange(preorder, i+1, preorder.length);
        node.right=buildTree(rightPreorder, rightInorder);
        return node;
    }
}