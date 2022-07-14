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
    public List<Integer> postorderTraversal(TreeNode root)
    {
        List<Integer> a=new ArrayList<Integer>();
        if(root==null) return a;
        //left->right->root
        Stack<TreeNode> s=new Stack<TreeNode>();
        s.push(root);
        while(!s.empty())
        {
            TreeNode t=s.peek();
            if(t.left!=null && t.left.val<101)
            {
                s.push(t.left);
                continue;
            }
            if(t.right!=null && t.right.val<101)
            {
                s.push(t.right);
                continue;
            }
            s.pop();
            a.add(t.val);
            t.val=101;
        }
        return a;
    }
}