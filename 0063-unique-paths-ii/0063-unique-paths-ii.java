class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        // If the start or end is blocked, return 0
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) return 0;

        int[][] dp = new int[m][n];
        dp[0][0] = 1; // Starting point

        // Fill DP table
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dp[i][j] = 0; // Obstacle cell
                } else {
                    if (i > 0) dp[i][j] += dp[i - 1][j]; // From top
                    if (j > 0) dp[i][j] += dp[i][j - 1]; // From left
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}