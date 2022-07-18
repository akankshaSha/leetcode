class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        TreeMap<Integer, Integer> colHead=new TreeMap<>();
        Queue <Node>nodes=new LinkedList<>();
        Queue <Integer>cols=new LinkedList<>();
        nodes.add(root);
        cols.add(0);
        while(!nodes.isEmpty())
        {
            Node node=nodes.remove();
            int col=cols.remove();
            colHead.put(col, node.data);
            if(node.left!=null)
            {
                nodes.add(node.left);
                cols.add(col-1);
            }
            if(node.right!=null)
            {
                nodes.add(node.right);
                cols.add(col+1);
            }
        }
        ArrayList<Integer> res=new ArrayList<>();
        for(int col: colHead.keySet())
        {
            res.add(colHead.get(col));
        }
        
        return res;
    }
}
