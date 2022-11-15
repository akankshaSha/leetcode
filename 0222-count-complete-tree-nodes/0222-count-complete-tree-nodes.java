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
    public int countNodes(TreeNode root) {
        if(root == null)return 0;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        int count = 0;
        while(!nodes.isEmpty())
        {
            TreeNode node = nodes.poll();
            count++;
            if(node.left!=null) nodes.offer(node.left);
            if(node.right!=null) nodes.offer(node.right);
        }
        
        return count;
    }
}