class Solution {
    public int numIslands(char[][] grid) {
	if (grid == null || grid.length == 0) {
	  return 0;
	}
	int nr = grid.length;
	int nc = grid[0].length;
	int num_islands = 0;
	Queue<int[]> queue=new LinkedList<>();
	for(int r=0;r<nr;r++){
		for(int c=0;c<nc;c++){
			if(grid[r][c]=='1'){
				queue.add(new int[]{r,c});
				num_islands++;
				while(!queue.isEmpty()){
					int[] curr=queue.poll();
					int row=curr[0];
					int col=curr[1];
					if(row<0 || col<0 || row>=nr || col>=nc || grid[row][col]=='0'){
						continue;
					}
					grid[row][col]='0';
					queue.add(new int[]{row+1,col});
					queue.add(new int[]{row-1,col});
					queue.add(new int[]{row,col+1});
					queue.add(new int[]{row,col-1});
				}
			}
		}
	}
	return num_islands;
}
}