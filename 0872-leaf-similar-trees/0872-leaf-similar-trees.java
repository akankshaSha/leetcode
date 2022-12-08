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
    List<Integer> leaves (TreeNode root)
    {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(root);
        while(!nodes.isEmpty())
        {
            TreeNode node = nodes.pop();
            if(node.left == null && node.right == null) res.add(node.val);
            if(node.right != null) nodes.push(node.right);
            if(node.left!=null) nodes.push(node.left);
        }
        return res;
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> one = leaves(root1);
        List<Integer> two = leaves(root2);
        if(one.size() != two.size()) return false;
        for(int i = 0; i<one.size(); i++) if(one.get(i) != two.get(i)) return false;
        return true;
    }
}