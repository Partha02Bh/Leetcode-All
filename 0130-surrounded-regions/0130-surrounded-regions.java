

class Solution {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; 

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || j == 0 || i == m - 1 || j == n - 1) && board[i][j] == 'O') {
                    queue.offer(new int[]{i, j});
                    board[i][j] = 'T'; 
                }
            }
        }
       while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];

            for (int[] dir : directions) {
                int newRow = r + dir[0], newCol = c + dir[1];
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && board[newRow][newCol] == 'O') {
                    queue.offer(new int[]{newRow, newCol});
                    board[newRow][newCol] = 'T'; 
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X'; 
                if (board[i][j] == 'T') board[i][j] = 'O'; 
            }
        }
    }
}
