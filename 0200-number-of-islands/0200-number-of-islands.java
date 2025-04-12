class Solution {
    int m,n;
    int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    public int numIslands(char[][] grid) {
        int count = 0;
        n = grid.length;
        if(n == 0) return 0;
        m = grid[0].length;

        //Create a visited set
        Set<String> visited = new HashSet<>();

        for(int i= 0 ; i < n ; i++){
            for(int j =0; j < m ; j++){
                if(grid[i][j] == '1' && !visited.contains(i+","+j)){
                    ++count;
                    bfs(i,j,grid,visited);
                }
            }
        }
        return count;
    }

    public void bfs(int i , int j, char[][] grid,Set<String> visited){

        //Add the row to visited
        visited.add(i+","+j);
        //Create a queue
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        while(!q.isEmpty()){
            int[] point = q.poll();
            int row = point[0];
            int col = point[1];
            for(int[] direction : directions){
                int nrow = row + direction[0];
                int ncol = col + direction[1];
                if(nrow >=0 && ncol >=0 && nrow < n && ncol < m && grid[nrow][ncol] == '1' && !visited.contains(nrow+","+ncol)){
                    q.add(new int[]{nrow,ncol});
                    visited.add(nrow+ "," + ncol);

                }
            }
        }


    }
}