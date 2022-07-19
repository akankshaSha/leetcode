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
    public TreeNode sortedArrayToBST(int[] nums) {
        int r=nums.length/2;
        TreeNode root=new TreeNode(nums[r]);
        if(nums.length==1) return root;
        if(r>0)root.left=sortedArrayToBST(Arrays.copyOfRange(nums, 0, r));
        if(nums.length>r+1)root.right=sortedArrayToBST(Arrays.copyOfRange(nums, r+1, nums.length));
        return root;
    }
}