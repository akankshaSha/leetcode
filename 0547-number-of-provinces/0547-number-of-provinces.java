class Solution {
    
    void dfs(int[][] isConnected, boolean visited[], int node)
    {
        if(visited[node]) return;
        visited[node]=true;
        for(int i=0; i<isConnected[node].length; i++)
            if(isConnected[node][i]==1) dfs(isConnected, visited, i);
    }
    
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length, districts=0;;
        boolean visited[]=new boolean[n];
        for(int i=0; i<n; i++)
        {
            if(!visited[i])
            {
                dfs(isConnected, visited, i);
                districts++;
            }
        }
        return districts;
    }
}