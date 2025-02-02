class Solution {
    public int numEnclaves(int[][] board) {
        int n = board.length;
        int m = board[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if ((i == 0 || j == 0 || i == n - 1 || j == m - 1) && board[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    board[i][j] = 2;
                }
            }
        }
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];

            for (int[] dir : directions) {
                int newRow = r + dir[0], newCol = c + dir[1];
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && board[newRow][newCol] == 1) {
                    queue.offer(new int[]{newRow, newCol});
                    board[newRow][newCol] = 2; 
                }
            }
        }
        int cnt = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if (board[i][j]==1) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}