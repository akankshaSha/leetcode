class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int pxc=image[sr][sc];
        image[sr][sc]=color;
        int dx[]={1, 0, -1, 0};
        int dy[]={0, 1, 0, -1};
        for(int i=0; i<4; i++)
        {
            int x=sr+dx[i], y=sc+dy[i];
            boolean inBounds= -1<x && x<image.length && -1<y && y<image[0].length;
            if(inBounds && image[x][y]==pxc && image[x][y]!=color) floodFill(image, x, y, color);
        }
        return image;
    }
}