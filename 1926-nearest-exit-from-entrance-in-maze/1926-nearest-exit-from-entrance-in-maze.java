class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> positions = new LinkedList<>();
        Queue<Integer> steps = new LinkedList<>();
        maze[entrance[0]][entrance[1]] = '+';
        positions.offer(entrance);
        steps.offer(0);
        
        while(!positions.isEmpty())
        {
            int[] position = positions.poll();
            int step = steps.poll();
            
            if(position != entrance && (position[0] == 0 || position[0] == maze.length -1 || position[1] == 0 || position[1] == maze[0].length -1))
                return step;
            
            // maze[position[0]][position[1]] = '+'; -> hall of shame
            int dx[]={0, 0, 1, -1}, dy[]={1, -1, 0, 0};
            
            for(int i = 0;i <4; i++)
            {
                int x = position[0] + dx[i], y = position[1] + dy[i];
                boolean inBounds = -1 < x && x < maze.length && -1 < y && y < maze[x].length;
                if(inBounds && maze[x][y] != '+')
                {
                    maze[x][y] = '+';
                    positions.offer(new int []{x,y});
                    steps.offer(step + 1);
                }
            }
        }
        return -1;
    }
}