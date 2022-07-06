class Solution {
    
    /*recursive solution:
    static int mdist(String s1, String s2, int index1, int index2)
    {
        if(index2==s2.length()) return s1.length()-index1;
        if(index1==s1.length()) return s2.length()-index2;
        if(s1.charAt(index1)==s2.charAt(index2)) return mdist(s1, s2, index1+1, index2+1);
        int insert= 1+mdist(s1, s2, index1, index2+1);
        int delete= 1+mdist(s1, s2, index1+1, index2);
        int update= 1+mdist(s1, s2, index1+1, index2+1);
        
        return insert<update ? (insert<delete ? insert : delete) : (update<delete ? update : delete);
    }
    */
    static int min(int a, int b, int c)
    {
        return a<b ? (a<c ? a : c) : (b<c ? b : c);
    }
    
    public int minDistance(String word1, String word2) {
        // return mdist(word1, word2, 0, 0);
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