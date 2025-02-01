class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        int timeElapsed = 0;

        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(grid[i][j]==2) {
                    queue.add(new int[]{i,j});
                }
                else if(grid[i][j]==1) {
                    freshCount++;
                }
            }
        }

        if(freshCount==0)    return 0;
        int directions[][] = {{0,1},{1,0},{0,-1},{-1,0}};

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rotted = false;  
            
            for (int i = 0; i < size; i++) {
                int[] rotten = queue.poll();
                int r = rotten[0], c = rotten[1];

                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2; 
                        queue.add(new int[]{nr, nc});  
                        freshCount--;  
                        rotted = true;  
                    }
                }
            }

            if (rotted) timeElapsed++;
        }
        return freshCount == 0 ? timeElapsed : -1;

    }
}