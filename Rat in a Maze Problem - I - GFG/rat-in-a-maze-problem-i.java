// { Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> fp(int m[][], int row, int col)
    {
        ArrayList<String> res=new ArrayList<>();
        if(row<0 || col<0 || row>=m.length || col>=m[0].length) return res;
        if(m[row][col]==0) return res;
        if(row==m.length-1 && col==m[row].length-1)
        {
            res.add("");
            return res;
        }
        
        m[row][col]=0;
        ArrayList<String> up=fp(m, row-1, col);
        ArrayList<String> down=fp(m, row+1, col);
        ArrayList<String> right=fp(m, row, col+1);
        ArrayList<String> left=fp(m, row, col-1);
        for(int i=0; i<up.size(); i++) up.set(i, "U"+up.get(i));
        for(int i=0; i<down.size(); i++) down.set(i, "D"+down.get(i));
        for(int i=0; i<right.size(); i++) right.set(i, "R"+right.get(i));
        for(int i=0; i<left.size(); i++) left.set(i, "L"+left.get(i));
        m[row][col]=1;
        res.addAll(up);
        res.addAll(down);
        res.addAll(left);
        res.addAll(right);
        return res;
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        return fp(m, 0, 0);
    }
}