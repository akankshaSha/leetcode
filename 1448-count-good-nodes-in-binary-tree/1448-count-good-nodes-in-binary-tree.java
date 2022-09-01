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
    public int goodNodes(TreeNode root) {
        Stack <TreeNode> nodes=new Stack<>();
        Stack <Integer> maxValues=new Stack<>();
        int count=1;
        nodes.push(root);
        maxValues.push(root.val);
        while(!nodes.empty())
        {
            TreeNode node=nodes.pop();
            int maxValue=maxValues.pop();
            if(node.left!=null) 
            {
                nodes.push(node.left);
                if(node.left.val>=maxValue) count++;
                maxValues.push(Math.max(maxValue, node.left.val));
            }
            if(node.right!=null) 
            {
                nodes.push(node.right);
                if(node.right.val>=maxValue) count++;
                maxValues.push(Math.max(maxValue, node.right.val));
            }
        }
        return count;
    }
}