class Solution {
    
    boolean dfs(List<List<Integer>> adj, HashSet<Integer> grey, HashSet<Integer> black, int node)
    {
        if(grey.contains(node)) return true;
        if(black.contains(node)) return false;
        grey.add(node);
        boolean res=false;
        for(int child: adj.get(node)) res=res || dfs(adj, grey, black, child);
        grey.remove(node);
        black.add(node);        
        return res;
    }
    
    boolean hasCycle(List<List<Integer>> adj)
    {
        HashSet<Integer> grey=new HashSet<>();
        HashSet<Integer> black=new HashSet<>();
        boolean res=false;
        for(int i=0; i<adj.size(); i++) res=res || dfs(adj, grey, black, i);
        return res;
    }
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0; i<numCourses; i++) adj.add(new ArrayList<>());
        
        for(int prerequisite[]: prerequisites)
        {
            List<Integer> children=adj.get(prerequisite[0]);
            children.add(prerequisite[1]);
            adj.set(prerequisite[0], children);
        }
        
        return !hasCycle(adj);
    }
}