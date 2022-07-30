class Solution {
    public List<List<Integer>> ways(int[][] graph, int s) {
        List<List<Integer>> res=new ArrayList<>();
        if(s==graph.length-1)
        {
            List<Integer> aux=new ArrayList<>();
            aux.add(s);
            res.add(aux);
            return res;
        }
        
        for(int edge: graph[s])
        {
            List<List<Integer>> next=ways(graph, edge);
            for(List<Integer>n: next) n.add(0, s);
            res.addAll(next);
        }
        return res;
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        return ways(graph, 0);
    }
}