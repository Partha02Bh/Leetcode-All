class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;
        

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, 0, 0});

        int[][] dist = new int[rows][cols];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int effort = curr[0], row = curr[1], col = curr[2];

            if (row == rows - 1 && col == cols - 1) return effort;
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                    int newEffort = Math.max(effort, Math.abs(heights[row][col] - heights[newRow][newCol]));
                    if (newEffort < dist[newRow][newCol]) {
                        dist[newRow][newCol] = newEffort;
                        pq.add(new int[]{newEffort, newRow, newCol});
                    }
                }
            }
        }

        return -1;
    }
}