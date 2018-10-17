class Q_063 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n+1];
        dp[1] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                if (obstacleGrid[i][j-1] == 1)
                    dp[j] = 0;
                else
                    dp[j] += dp[j-1];
            }
        }
        return dp[n];
    }
}