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
    public List<List<Integer>> levelOrder(TreeNode root) 
    {
        List<Integer> values=new ArrayList<Integer>();
        List<List<Integer>> lvl=new ArrayList<List<Integer>>();
        if(root==null)
            return lvl;
        Queue <TreeNode> tr=new LinkedList<TreeNode>();
        tr.add(root);
        int p=0,q=0,r=1;
        while(!tr.isEmpty())
        {
            if(q==0)
            {
                p=r;
                r=0;
            }
            values.add(tr.peek().val);
            q++;
            if(p==q)
            {
                lvl.add(new ArrayList<Integer>(values));
                values.clear();
                q=0;
            }
            TreeNode t=tr.poll();
            if(t.left!=null)
            {
                tr.add(t.left);
                r++;
            }
            if(t.right!=null)
            {
                tr.add(t.right);
                r++;
            }
        }
        
        return lvl;
    }
}