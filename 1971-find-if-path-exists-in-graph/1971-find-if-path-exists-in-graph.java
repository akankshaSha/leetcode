class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        HashMap<Integer, List<Integer>> adjList=new HashMap<>();
        for(int pair[]: edges)
        {
            List<Integer> edgeL=adjList.getOrDefault(pair[0], new ArrayList<>());
            edgeL.add(pair[1]);
            adjList.put(pair[0], edgeL);
            
            edgeL=adjList.getOrDefault(pair[1], new ArrayList<>());
            edgeL.add(pair[0]);
            adjList.put(pair[1], edgeL);
        }
       
        
        Stack<Integer> nodes=new Stack<>();
        HashSet<Integer> visited=new HashSet<>();
        nodes.add(source);
        while(!nodes.isEmpty())
        {
            int node=nodes.pop();
            if(node==destination) return true;
            if(visited.contains(node)) continue;
            List<Integer> neigh=adjList.get(node);
            visited.add(node);
            for(int ne: neigh) nodes.push(ne);
        }
        return false;
    }
}