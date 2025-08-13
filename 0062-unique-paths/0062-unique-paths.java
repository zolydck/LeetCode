class Solution {
    public int uniquePaths(int m, int n) {

        //m rows , n columns
        //dp[0][0] represents number of ways to reach cell 0,0
        //dp[m-1][n-1] represents number of ways to reach cell m-1,n-1
        int[][] dp = new int[m][n];
        for(int j = 0 ; j < n ; j++){
            dp[0][j]=1;
        }
        for(int i = 0 ; i < m ; i++){
            dp[i][0]=1;
        }
        for(int i = 1 ; i < m ; i++) {
            for(int j = 1 ; j < n ; j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
        
    }
}