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
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        
        Stack <TreeNode> nodes =new Stack<>();
        Stack <Integer> d=new Stack<>();
        
        nodes.push(root);
        d.push(1);
        int max=0;
        
        while(!nodes.empty())
        {
            TreeNode t=nodes.pop();
            int h=d.pop();
            if(t.left==null && t.right==null)
            {
                max=Math.max(max, h);
                continue;
            }
            if(t.left!=null)
            {
                nodes.push(t.left);
                d.push(h+1);
            }
            if(t.right!=null)
            {
                nodes.push(t.right);
                d.push(h+1);
            }
        }
        return max;
    }
}

/* // recursive soln:
    public int maxDepth(TreeNode root) {
       if(root==null) return 0;
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        return 1+ Math.max(left, right);
    }
*/