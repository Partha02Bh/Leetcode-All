class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Step 2: Fill the adjacency list
        for (int[] time : times) {
            adj.get(time[0]).add(new int[]{time[1], time[2]});  // {neighbor, time}
        }

        // Step 3: Priority Queue (Min-Heap) for Dijkstra’s Algorithm
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, k});  // {time, node}

        // Step 4: Distance array (Shortest time to reach each node)
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;  // Start node distance is 0

        // Step 5: Dijkstra’s Algorithm
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0], node = curr[1];

            if (time > dist[node]) continue;  // Ignore outdated paths

            for (int[] neighbor : adj.get(node)) {
                int nextNode = neighbor[0], travelTime = neighbor[1];
                int newTime = time + travelTime;

                if (newTime < dist[nextNode]) {
                    dist[nextNode] = newTime;
                    pq.add(new int[]{newTime, nextNode});
                }
            }
        }

        // Step 6: Find the maximum time among all reachable nodes
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1; // Some node is unreachable
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}