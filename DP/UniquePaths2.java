// leet 63
class Solution {
    int[][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        dp = new int[m+1][n+1];
        if(obstacleGrid[m-1][n-1]==1) return 0;
        for(int i=0; i<m; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(obstacleGrid, m, n, 0, 0);
    }

    private int solve(int[][] obstacleGrid, int m, int n, int i, int j){
        if(i==m-1 && j==n-1) return 1;
        if((i>=m || j>=n) || obstacleGrid[i][j]==1) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        return dp[i][j]=solve(obstacleGrid, m, n, i+1, j)+solve(obstacleGrid, m, n, i, j+1);
    }
}
