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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        List<List<Integer>> left=new ArrayList<>(), right=new ArrayList<>();
        if(root.left!=null) left=pathSum(root.left, targetSum-root.val);
        if(root.right!=null) right=pathSum(root.right, targetSum-root.val);
        for(List<Integer> path: left)
        {
            path.add(0, root.val);
            res.add(path);
        }
        for(List<Integer> path: right)
        {
            path.add(0, root.val);
            res.add(path);
        }
        if(root.left==null && root.right==null && root.val==targetSum)
        {
            List<Integer> aux=new ArrayList<>();
            aux.add(root.val);
            res.add(aux);
        }
        return res;
    }
}