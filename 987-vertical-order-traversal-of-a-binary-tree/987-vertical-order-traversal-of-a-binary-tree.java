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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map =new TreeMap<>();
        /*{
            col1: 
            {
                lvl1 : [val, val...]
                lvl2 : [val, val...]
                ...
            }
            col2: 
            {
                lvl1 : [val, val...]
                lvl2 : [val, val...]
                ...
            }
            ...
        }*/
        Stack<TreeNode> nodes=new Stack<>();
        Stack<Integer> cols=new Stack<>();
        Stack<Integer> lvls=new Stack<>();
        nodes.push(root);
        cols.push(0);
        lvls.push(0);
        while(!nodes.empty())
        {
            TreeNode node=nodes.pop();
            int col=cols.pop();
            int lvl=lvls.pop();
            TreeMap<Integer, List<Integer>> r =map.getOrDefault(col, new TreeMap<Integer, List<Integer>>());
            List<Integer> nodeList=r.getOrDefault(lvl, new ArrayList<Integer>());
            nodeList.add(node.val);
            r.put(lvl, nodeList);
            map.put(col, r);
            
            if(node.right!=null)
            {
                nodes.push(node.right);
                cols.push(col-1);
                lvls.push(lvl+1);
            }
            if(node.left!=null)
            {
                nodes.push(node.left);
                cols.push(col+1);
                lvls.push(lvl+1);
            }
        }
        
        for(TreeMap<Integer, List<Integer>> levels: map.values())
        {
            for(List<Integer> nodevals: levels.values())
            {
                Collections.sort(nodevals);
            }
        }
        
        List<List<Integer>> res=new ArrayList<>();
        for(int col: map.keySet())
        {
            List<Integer> nodevals=new ArrayList<>();
            TreeMap<Integer, List<Integer>> nodelvls=map.get(col);
            for(int lvl: nodelvls.keySet())
            {
                nodevals.addAll(nodelvls.get(lvl));
            }
            res.add(0, nodevals);
        }
        return res;
    }
}