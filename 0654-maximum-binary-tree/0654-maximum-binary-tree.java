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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int m = 0;
        for(int i = 0; i < nums.length; i++) if(nums[i] > nums[m]) m = i;
        
        TreeNode root = new TreeNode(nums[m]);
        if(m > 0) root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, m));
        if(m+1 < nums.length) root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, m+1, nums.length));
        return root;
    }
}