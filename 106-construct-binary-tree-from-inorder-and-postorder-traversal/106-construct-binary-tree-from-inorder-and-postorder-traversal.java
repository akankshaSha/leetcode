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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
       if(inorder.length==0 || postorder.length==0) return null;
        int i=0;
        for(; i<inorder.length; i++)
            if(inorder[i]==postorder[postorder.length-1]) break;
        TreeNode node=new TreeNode(inorder[i]);
        int[] leftInorder=Arrays.copyOfRange(inorder, 0, i);
        int[] leftPostorder=Arrays.copyOfRange(postorder, 0, i);
        node.left=buildTree(leftInorder, leftPostorder);
        int[] rightInorder=Arrays.copyOfRange(inorder, i+1, inorder.length);
        int[] rightPostorder=Arrays.copyOfRange(postorder, i, postorder.length-1);
        node.right=buildTree(rightInorder, rightPostorder);
        return node; 
    }
}