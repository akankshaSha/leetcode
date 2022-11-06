class Solution {
    public int uniquePaths(int m, int n) {
        int paths[][]=new int[m+1][n+1];
        for(int i = 1; i<=m; i++)
        {
            for(int j=1; j<=n; j++)
            {
                if(i == 1 && j == 1) paths[i][j] = 1;
                else paths[i][j] = paths[i-1][j] + paths[i][j-1];
            }
        }
        return paths[m][n];
    }
}

/*
class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 1 && n == 1) return 1;
        if(m == 0 || n == 0) return 0;
        int down = uniquePaths(m-1, n);
        int right = uniquePaths(m, n-1);
        return down + right;
    }
}
*/