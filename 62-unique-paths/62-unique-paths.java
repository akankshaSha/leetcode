class Solution {
    static int memory[][]=new int[101][101];
    public int uniquePaths(int m, int n) {
        if(m==1)
        {
            if(n==1) return 1;
            if(memory[m][n] == 0)
                memory[m][n] = uniquePaths(m, n-1);
            return memory[m][n];
        }
        if(n==1)
        {
            if(m==1) return 1;
            if(memory[m][n] == 0)
                memory[m][n] = uniquePaths(m-1, n);
            return memory[m][n];
        }
        if(memory[m][n]==0)
            memory[m][n] = uniquePaths(m, n-1) + uniquePaths(m-1, n);
        
        return memory[m][n];
    }
}