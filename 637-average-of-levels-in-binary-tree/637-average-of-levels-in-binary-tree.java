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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res=new ArrayList<>();
        Queue<TreeNode> nodes=new LinkedList<>();
        Queue<Integer> lvls=new LinkedList<>();
        nodes.offer(root);
        lvls.offer(0);
        int currentLvl=0, numberOfNodes=0;
        long sum=0;
        while(!nodes.isEmpty())
        {
            TreeNode node=nodes.poll();
            int lvl=lvls.poll();
            if(lvl>currentLvl)
            {
                double avg=(double)sum/numberOfNodes;
                res.add(avg);
                sum=numberOfNodes=0;
                currentLvl=lvl;
            }
            
            sum+=node.val;
            numberOfNodes++;
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
        res.add((double)sum/numberOfNodes);
        return res;
    }
}