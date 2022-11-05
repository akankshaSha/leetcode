class Solution {
    boolean dfs(List<List<Integer>> adj, boolean black[], boolean grey[], int node, Stack<Integer>sort)
    {
        if(grey[node]) return false;
        if(black[node]) return true;
        boolean res = true;
        grey[node] = true;
        black[node] = true;
        for(int child : adj.get(node)) res = res && dfs(adj, black, grey, child, sort);
        grey[node] = false;
        sort.push(node);
        return res;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        //1. make adj list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++) adj.add(new ArrayList<>());
        for(int prerequisite[] : prerequisites)
        {
            List<Integer> children = adj.get(prerequisite[1]);
            children.add(prerequisite[0]);
        }
        
        //2. topologically sort the graph
        
        int res[]=new int[numCourses];
        Stack<Integer> node = new Stack<>();
        Stack<Integer> sort = new Stack<>();
        boolean black[] = new boolean[numCourses];
        boolean grey[] = new boolean[numCourses];
        for(int i=0; i<numCourses; i++)
        {
            if(black[i]) continue;
            if(!dfs(adj, black, grey, i, sort)) return new int[]{};
        }
        
        //3. return
        int i=0;
        while(!sort.isEmpty()) res[i++]=sort.pop();
        return res;
    }
}