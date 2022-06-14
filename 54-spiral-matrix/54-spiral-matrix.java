class Solution {
    public List<Integer> spiralOrder(int[][] mat) 
    {
        boolean visited [][]=new boolean[mat.length][mat[0].length];
        List<Integer> e=new ArrayList<>();
        int a=mat[0].length, b=mat.length, c=0;
        while(c<a && c<b)
        {
            for(int i=c; i<a; i++) {
                if(visited[c][i]) continue;
                visited[c][i]=true;
                e.add(mat[c][i]);
            }
            for(int i=c+1; i<b; i++) {
                if(visited[i][a-1]) continue;
                visited[i][a-1]=true;
                e.add(mat[i][a-1]);
            }
            for(int i=a-2; i>c; i--) {
                if(visited[b-1][i]) continue;
                visited[b-1][i]=true;
                e.add(mat[b-1][i]);
            }
            for(int i=b-1; i>c; i--) {
                if(visited[i][c]) continue;
                visited[i][c]=true;
                e.add(mat[i][c]);
            }
            a--;
            b--;
            c++;
        }
        return e;
    }
}