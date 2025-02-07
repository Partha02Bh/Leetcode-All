class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
      

        if(grid[0][0]==1 || grid[n-1][n-1]==1) {
            return -1;
        }
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][n];

        q.add(new int[]{0, 0, 1});
        vis[0][0] = true;
        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        while(!q.isEmpty()){
            int[] current = q.poll();
            int row = current[0];
            int col = current[1];
            int steps = current[2];
            if (row == n - 1 && col == n - 1) return steps;

            for(int[] dir: directions) {
                int nRow = row + dir[0];
                int nCol = col + dir[1];

                if(nRow>=0 && nRow<n && nCol>=0 && nCol<n && !vis[nRow][nCol] && grid[nRow][nCol]==0) {
                    q.add(new int[]{nRow, nCol, steps + 1});
                    vis[nRow][nCol] = true; 
                }
            }
        }
        return -1;
    }
}