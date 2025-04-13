class Solution {
    public int orangesRotting(int[][] grid) {

        Queue<int[]> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                }
                if(grid[i][j]==1){
                    count++;
                }
            }
        }
        if(count == 0) return 0;
        if(q.isEmpty()) return -1;
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        int t = 0;
        while(!q.isEmpty()){
            int len = q.size();
            t++;
            for(int l = 0 ; l < len ; l++){
                int[] point = q.poll();
                for(int[] d : dir ){
                    int nrow = point[0]+d[0];
                    int ncol = point[1]+d[1];
                    if(nrow >= 0 && ncol >=0 && nrow < n && ncol < m && grid[nrow][ncol] == 1){
                        grid[nrow][ncol] = 2;
                        count--;
                        q.offer(new int[]{nrow,ncol});
                    }
                }
            }
            if(count == 0) return t;


        }
        return -1;
        
    }
}