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
    //recursive soln
    /*public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null) return new ArrayList<Integer>();
        List<Integer> left=preorderTraversal(root.left);
        List<Integer> right=preorderTraversal(root.right);
        List<Integer> res=new ArrayList<Integer>();
        res.add(root.val);
        res.addAll(left);
        res.addAll(right);
        return res;
    }*/
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<Integer>();
        if(root==null) return res;        
        Stack <TreeNode> s=new Stack<>();
        s.push(root);
        while(!s.isEmpty())
        {
            TreeNode t=s.pop();
            if(t.right!=null)
            {
                s.push(t.right);
            }
            if(t.left!=null)
            {
                s.push(t.left);
            }
            res.add(t.val);
        }
        return res;
    }
}