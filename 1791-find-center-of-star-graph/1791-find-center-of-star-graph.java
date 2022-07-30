class Solution {
    public int findCenter(int[][] edges) {
        int N=0;
        HashMap<Integer, Integer> nodeEdge=new HashMap<>();
        for(int i=0; i<edges.length;  i++)
        {
            nodeEdge.put(edges[i][0], nodeEdge.getOrDefault(edges[i][0], 0)+1);
            nodeEdge.put(edges[i][1], nodeEdge.getOrDefault(edges[i][1], 0)+1);
            N=Math.max(N, edges[i][0]);
            N=Math.max(N, edges[i][1]);
        }
        
        for(int node: nodeEdge.keySet()) if(nodeEdge.get(node)==N-1) return node;
        return 0;
    }
}