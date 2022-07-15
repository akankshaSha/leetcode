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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root==null) return res;
        
        Queue<TreeNode> nodes=new LinkedList<>(); 
        Queue<Integer> lvls=new LinkedList<>();
        nodes.add(root);
        lvls.add(0);
        int nextLvl=0;
        while(!nodes.isEmpty())
        {
            TreeNode node=nodes.remove();
            int lvl=lvls.remove();
            if(lvl==nextLvl)
            {
                res.add(node.val);
                nextLvl++;
            }
            if(node.right!=null)
            {
                nodes.add(node.right);
                lvls.add(lvl+1);
            }
            if(node.left!=null)
            {
                nodes.add(node.left);
                lvls.add(lvl+1);
            }
        }
        
        return res;
    }
}