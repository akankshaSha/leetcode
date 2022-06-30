class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int [][] cache=new int[s1.length()+1][s2.length()+1];
        for(int i=1; i<cache.length; i++)
        {
            for(int j=1; j<cache[i].length; j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    cache[i][j]=1+cache[i-1][j-1];
                else
                    cache[i][j]=Math.max(cache[i][j-1], cache[i-1][j]);
            }
        }
        return cache[s1.length()][s2.length()];
    }
}