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
    TreeNode getInorderPredecessor(TreeNode snode)
    {
        TreeNode node=snode.left;
        while(node.right!=null && node.right!=snode) node=node.right;
        return node;
    }
    
    public int kthSmallest(TreeNode root, int k) {
        int e=0;
        TreeNode node=root;
        while(node!=null)
        {
            if(node.left==null)
            {
                e=node.val;
                k--;
                if(k==0) break;
                node=node.right;
            }
            else
            {
                TreeNode pred=getInorderPredecessor(node);
                if(pred.right==null)
                {
                    pred.right=node;
                    node=node.left;
                }
                else
                {
                    e=node.val;
                    k--;
                    if(k==0) break;
                    pred.right=null;
                    node=node.right;
                }
            }
        }
        return e;
    }
}