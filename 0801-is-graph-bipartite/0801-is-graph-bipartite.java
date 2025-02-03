class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n]; 
        Arrays.fill(color, 0);

        for (int i = 0; i < n; i++) {
            if (color[i] == 0) { 
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                color[i] = 1; 
                
                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    
                    for (int neighbor : graph[node]) {
                        if (color[neighbor] == 0) { 
                            color[neighbor] = -color[node];
                            queue.offer(neighbor);
                        } else if (color[neighbor] == color[node]) { 
                            return false; 
                        }
                    }
                }
            }
        }
        return true;
    }
}