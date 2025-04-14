class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {

        Queue<int[]>q = new LinkedList<>();
        q.offer(entrance);
        maze[entrance[0]][entrance[1]]='+';
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        int rows = maze.length;
        int cols = maze[0].length;
        int steps = 0;
        while(!q.isEmpty()){
            steps++;
            int len = q.size();
            int newX,newY;
            for(int i = 0 ; i < len ; i++){
                int[] curr = q.poll();
                int curX = curr[0];
                int curY = curr[1];
                for(int[] dir : directions){
                    newX = curX+dir[0];
                    newY = curY+dir[1];
                    if(newX < 0 || newY < 0 || newX >= rows || newY >= cols) continue;
                    if(maze[newX][newY] == '+') continue;
                    if(newX == 0 || newX == rows-1 || newY == 0 || newY == cols-1) return steps;
                    q.offer(new int[] {newX,newY});
                    maze[newX][newY] = '+';
                }
            }
        }
        return -1;
        
    }
}