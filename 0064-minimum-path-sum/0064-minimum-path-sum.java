class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int dp[][] = new int[n][m];
        for (int i= 0;i<n;i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(n-1,m-1,grid,dp);
    }
    private int solve(int i, int j, int[][] grid, int[][] dp) {
        if(i==0 & j==0) {
            return grid[0][0];
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int up=Integer.MAX_VALUE;
       if(i>0) up=grid[i][j]+solve(i-1,j,grid,dp);
        int left=Integer.MAX_VALUE;
       if(j>0) left=grid[i][j]+solve(i,j-1,agridns,dp);

        return dp[i][j]=Math.min(up,left);
    }
}