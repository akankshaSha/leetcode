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
    List<Integer> inorder(TreeNode root)
    {
        List<Integer> res=new ArrayList<>();
        if(root.left==null && root.right==null)
        {
            res.add(root.val);
            return res;
        }
        List<Integer> left=new ArrayList<>(), right=new ArrayList<>();
        if(root.left!=null) left=inorder(root.left);
        if(root.right!=null) right=inorder(root.right);
        res.addAll(left);
        res.add(root.val);
        res.addAll(right);
        return res;
    }
    TreeNode sortedArrayToBST(List<Integer> nums) {
        int r=nums.size()/2;
        TreeNode root=new TreeNode(nums.get(r));
        if(nums.size()==1) return root;
        if(r>0)root.left=sortedArrayToBST(nums.subList(0, r));
        if(nums.size()>r+1)root.right=sortedArrayToBST(nums.subList(r+1, nums.size()));
        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> values=inorder(root);
        return sortedArrayToBST(values);
    }
}