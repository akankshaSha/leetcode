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
    
    int findSet(int set[], int n)
    {
        int i=n;
        while(set[i]!=i) i=set[i];
        set[n]=i;
        return i;
    }
    
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int set[]=new int[V];
        //make set
        for(int i=0; i<V; i++) set[i]=i;
        
        for(int node=0; node<V; node++)
        {
            for(int child: adj.get(node))
            {
                if(child>node) //to ensure exploration of unique edges
                {
                    int a=findSet(set, node), b=findSet(set, child);
                    if(a==b) return true;
                    set[b]=a;
                }
            }
        }
        return false;
    }
}