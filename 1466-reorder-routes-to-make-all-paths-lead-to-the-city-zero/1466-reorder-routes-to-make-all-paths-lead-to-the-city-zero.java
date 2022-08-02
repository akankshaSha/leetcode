class Node
{
    int n;
    boolean oe;
    Node(int n, boolean oe)
    {
        this.n=n;
        this.oe=oe;
    }
    
    public String toString()
    {
        return n+"["+oe+"]";
    }
}
class Solution {
    public int dft(HashMap<Integer, ArrayList<Node>> g, int parent, int child, HashSet<Integer> v)
    {
        int res=0;
        if(v.contains(child)) return res;
        v.add(child);
        List<Node> neighbours=g.get(child);
        for(Node neighbour: neighbours)
        {
            
            res+=dft(g, child, neighbour.n, v);
            if(neighbour.n==parent && neighbour.oe==true) res++;
            //System.out.println(parent+" "+ child+" "+ res);
        }
        return res;
    }
    
    public int minReorder(int n, int[][] connections) {
        HashMap<Integer, ArrayList<Node>> g=new HashMap<>();
        for(int connection[]: connections)
        {
            ArrayList<Node> neighbours=g.getOrDefault(connection[0], new ArrayList<>());
            neighbours.add(new Node(connection[1], false));
            g.put(connection[0], neighbours);
            neighbours=g.getOrDefault(connection[1], new ArrayList<>());
            neighbours.add(new Node(connection[0], true));
            g.put(connection[1], neighbours);
        }
        
        int count=dft(g, -1, 0, new HashSet<Integer>());
        
        return count;
    }
}