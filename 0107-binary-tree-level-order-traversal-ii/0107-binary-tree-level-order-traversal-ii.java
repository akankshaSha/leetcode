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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> lvls = new LinkedList<>();
        nodes.offer(root);
        lvls.offer(0);
        int cl = 0;
        List<Integer> aux = new ArrayList<>();
        while(!nodes.isEmpty())
        {
            TreeNode node = nodes.poll();
            int lvl = lvls.poll();
            if(lvl > cl)
            {
                res.add(aux);
                aux = new ArrayList<>();
                cl = lvl;
            }
            aux.add(node.val);
            if(node.left != null)
            {
                nodes.offer(node.left);
                lvls.offer(lvl + 1);
            }
            if(node.right != null)
            {
                nodes.offer(node.right);
                lvls.offer(lvl +1);
            }
        }
        res.add(aux);
        Collections.reverse(res);
        return res;
    }
}