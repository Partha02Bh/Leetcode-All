class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] visited = new boolean[n][m];

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[]{i, j}); 
                    visited[i][j] = true; 
                }
            }
        }
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; 
        while(!q.isEmpty()) {
            int[] nod = q.poll();
            int x = nod[0];
            int y = nod[1];
            for(int[] dir: directions) {
                int newRow = x+dir[0];
                int newCol = y+dir[1];

                if(newRow>=0 && newRow<n && newCol>=0 && newCol<m && !visited[newRow][newCol]) {
                    q.add(new int[]{newRow,newCol});
                    visited[newRow][newCol] = true;
                    mat[newRow][newCol] = mat[x][y]+1;

                }
            }
        }
        return mat;
    }
}