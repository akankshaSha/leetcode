// connected components 
//Approach 1: Traversal 
class Solution {
    void dfs(List<List<Integer>> rooms, boolean visited[], int node)
    {
        visited[node] = true;
        for(int key : rooms.get(node))
        {
            if(!visited[key]) dfs(rooms, visited, key);
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean visited[] = new boolean [rooms.size()];
        dfs(rooms, visited, 0);
        for(boolean visit : visited) if(!visit) return false;
        return true;
    }
}

