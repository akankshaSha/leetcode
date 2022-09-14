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
    int count(TreeNode root, HashSet<Integer> unmatched)
    {
        if(root==null) return 0;
        if(unmatched.contains(root.val)) unmatched.remove(root.val);
        else unmatched.add(root.val);
        if(root.left==null && root.right==null)
        {
            if(unmatched.size()<2) return 1;
            else return 0;
        }
        return count(root.right, new HashSet<>(unmatched)) + count(root.left, new HashSet<>(unmatched));
    }
    public int pseudoPalindromicPaths (TreeNode root) {
        return count(root, new HashSet<Integer>());
    }
}