/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        HashMap<Node, Node> oc=new HashMap<>();
        HashSet<Node> visited=new HashSet<>();
        Stack<Node> nodes=new Stack<>();
        nodes.push(node);
        visited.add(node);
        while(!nodes.isEmpty())
        {
            Node n=nodes.pop();
            Node copy=new Node(n.val);
            oc.put(n,copy);
            List<Node> neighbors=n.neighbors;
            for(Node neighbor: neighbors) 
            {
                if(!visited.contains(neighbor))
                {
                    nodes.push(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        visited.clear();
        nodes.push(node);
        visited.add(node);
        while(!nodes.isEmpty())
        {
            Node o=nodes.pop();
            Node c=oc.get(o);
            List<Node> neighbors=o.neighbors;
            for(Node neighbor: neighbors) 
            {
                Node neighborCopy=oc.get(neighbor);
                c.neighbors.add(neighborCopy);
                if(!visited.contains(neighbor))
                {
                    nodes.push(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        
        return oc.get(node);
    }
}