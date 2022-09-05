/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        Queue<Node> nodes=new LinkedList<>();
        TreeMap<Integer, List<Integer>> lvlNodes=new TreeMap<>();
        Queue<Integer> lvls=new LinkedList<>();
        nodes.offer(root);
        lvls.offer(0);
        while(!nodes.isEmpty())
        {
            Node node=nodes.poll();
            int lvl=lvls.poll();
            List<Integer> list=lvlNodes.getOrDefault(lvl, new ArrayList<>());
            list.add(node.val);
            lvlNodes.put(lvl, list);
            List<Node> children=node.children;
            for(Node child: children)
            {
                nodes.offer(child);
                lvls.offer(lvl+1);
            }
        }
        for(int lvl: lvlNodes.keySet())
        {
            List<Integer> aux=lvlNodes.get(lvl);
            res.add(aux);
        }
        return res;
    }
}