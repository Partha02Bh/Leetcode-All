class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int INF = (int) 1e9; // Large value for initialization
        
        // Step 1: Create an adjacency matrix and initialize with INF
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0; // Distance to self is 0
        }
        
        // Step 2: Fill the adjacency matrix with given edges
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            dist[u][v] = w;
            dist[v][u] = w; // Since it's bidirectional
        }
        
        // Step 3: Floyd-Warshall Algorithm to compute shortest paths
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] < INF && dist[k][j] < INF) { // Prevent overflow
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        
        // Step 4: Count reachable cities for each city
        int minReachable = n; // To track the minimum number of reachable cities
        int bestCity = -1; // To track the answer
        
        for (int i = 0; i < n; i++) {
            int reachable = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= distanceThreshold) {
                    reachable++;
                }
            }
            
            // Step 5: Update the best city
            if (reachable <= minReachable) { // We choose the **greatest index** in case of tie
                minReachable = reachable;
                bestCity = i;
            }
        }
        
        return bestCity;
    }
}