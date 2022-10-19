//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean detectCycle(int V, ArrayList<ArrayList<Integer>> adj, int s, boolean visited[]) {
        Stack<Integer> nodes=new Stack<>();
        Stack<Integer> sources=new Stack<>();
        nodes.push(s);
        sources.push(-1);
        while(!nodes.isEmpty())
        {
            int node=nodes.pop();
            int source=sources.pop();
            if(visited[node]) return true;
            visited[node]=true;
            for(int child: adj.get(node))
            {
                if(visited[child]) continue;
                nodes.push(child);
                sources.push(node);
            }
        }
        return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[]=new boolean[V];
        for(int i=0; i<visited.length; i++)
        {
            if(!visited[i] && detectCycle(V, adj, i, visited)) return true;
        }
        return false;
    }
}