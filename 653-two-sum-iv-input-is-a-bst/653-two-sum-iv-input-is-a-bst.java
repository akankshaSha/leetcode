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
    static boolean search(TreeNode root, int k)
    {
        if(root==null) return false;
        if(root.val>k)
            return search(root.left, k);
        if(root.val<k)
            return search(root.right, k);
        return true;
    }
    
    public boolean findTarget(TreeNode root, int k)
    {        
        Stack <TreeNode> e=new Stack<TreeNode>();
        e.push(root);
        while(!e.empty())
        {
            TreeNode t=e.pop();
            if(t.left!=null)
            {
                e.push(t.left);
            }
            if(t.right!=null)
            {
                e.push(t.right);
            }
            
            if(t.val==k-t.val) continue;            
            if(search(root, k-t.val)) return true;
        }
        return false;
    }
}