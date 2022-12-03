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
    List<Integer> inorder(TreeNode node)
    {
        List<Integer> res = new ArrayList<>();
        if(node == null) return res;
        List<Integer> left = inorder(node.left);
        List<Integer> right = inorder(node.right);
        res.addAll(left);
        res.add(node.val);
        res.addAll(right);
        return res;
    }
    public int getMinimumDifference(TreeNode root) {
        List<Integer> inorder = inorder( root);
        int res = Integer.MAX_VALUE;
        for(int i = 0; i<inorder.size()-1; i++) res = Math.min(res, inorder.get(i+1) - inorder.get(i));
        return res;
    }
}