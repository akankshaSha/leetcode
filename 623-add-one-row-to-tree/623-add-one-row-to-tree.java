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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1)
        {
            TreeNode newRoot=new TreeNode(val);
            newRoot.left=root;
            return newRoot;
        }
        
        List<TreeNode> atDepth=new ArrayList<>();
        Queue<TreeNode> nodes=new LinkedList<>();
        Queue<Integer> lvls=new LinkedList<>();
        nodes.offer(root);
        lvls.offer(1);
        while(!nodes.isEmpty())
        {
            TreeNode node=nodes.poll();
            int lvl=lvls.poll();
            if(lvl==depth) break;
            else if(lvl==depth-1) atDepth.add(node);
            if(node.left!=null)
            {
                nodes.offer(node.left);
                lvls.offer(lvl+1);
            }
            if(node.right!=null)
            {
                nodes.offer(node.right);
                lvls.offer(lvl+1);
            }
        }
        
        for(TreeNode node: atDepth)
        {
            TreeNode left=new TreeNode(val, node.left, null);
            TreeNode right=new TreeNode(val, null, node.right);
            node.left=left;
            node.right=right;
        }
        return root;
    }
}