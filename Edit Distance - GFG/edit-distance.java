// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    static int min(int a, int b, int c)
    {
        return a<b ? (a<c ? a : c) : (b<c ? b : c);
    }
    
    public int editDistance(String word1, String word2) {
        int l1=word1.length(), l2=word2.length();
        int M[][]=new int[l1+1][l2+1];
        for(int i=0; i<=l1; i++) M[i][l2]=l1-i;
        for(int i=0; i<=l2; i++) M[l1][i]=l2-i;
        for(int i=l1-1; i>=0; i--)
        {
            for(int j=l2-1; j>=0; j--)
            {
                if(word1.charAt(i)==word2.charAt(j))
                    M[i][j]=M[i+1][j+1];
                else
                    M[i][j]=min(M[i+1][j], M[i][j+1], M[i+1][j+1])+1;
            }
        }
        return M[0][0];
    }
}