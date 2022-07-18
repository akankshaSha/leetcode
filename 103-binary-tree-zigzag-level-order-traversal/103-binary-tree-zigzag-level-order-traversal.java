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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        HashMap<Integer, List<Integer>> map=new HashMap<>();
        Queue <TreeNode> nodes=new LinkedList<>();
        Queue <Integer> lvls=new LinkedList<>();
        nodes.add(root);
        lvls.add(0);
        while(!nodes.isEmpty())
        {
            TreeNode node=nodes.remove();
            int lvl=lvls.remove();
            List<Integer> nodeVal=map.getOrDefault(lvl, new ArrayList<>());
            nodeVal.add(node.val);
            map.put(lvl, nodeVal);
            if(node.left!=null)
            {
                nodes.add(node.left);
                lvls.add(lvl+1);
            }
            if(node.right!=null)
            {
                nodes.add(node.right);
                lvls.add(lvl+1);
            }
        }
        
        for(int lvl: map.keySet())
        {
            if(lvl%2==0)
                res.add(map.get(lvl));
            else 
            {
                Collections.reverse(map.get(lvl));
                res.add(map.get(lvl));
            }
        }
        return res;
    }
}