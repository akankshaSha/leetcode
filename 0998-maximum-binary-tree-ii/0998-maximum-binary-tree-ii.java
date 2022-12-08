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
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);
        if(root.val < val)
        {
            newNode.left = root;
            return newNode;
        }
        
        TreeNode node = root;
        boolean inserted = false;
        while(node.right != null)
        {
            if(node.right.val < val)
            {
                TreeNode rightSubTree = node.right;
                node.right = newNode;
                newNode.left = rightSubTree;
                inserted = true;
            }
            else node = node.right;
        }
        if(!inserted) node.right = newNode;
        return root;
    }
}