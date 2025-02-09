class Solution {
    public int countPaths(int n, int[][] roads) {
        final int MOD = 1_000_000_007;
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) {
            adj.add(new ArrayList<>());
        }

        for(int road[] : roads) {
            int u = road[0];
            int v = road[1];
            int time = road[2];
            adj.get(u).add(new int[] {v, time});
            adj.get(v).add(new int[] {u, time});
        }

        long dist[] = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0]=0;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0, 0});

        int[] ways = new int[n];
        ways[0] = 1; 

        while(!pq.isEmpty()) {
            long curr[] = pq.poll();
            long currTime = curr[0];
            int node = (int) curr[1];

            if(currTime > dist[node])    continue;
            
            for (int[] neighbor : adj.get(node)) {
                int nextNode = neighbor[0];
                long newTime = currTime + neighbor[1];

                if (newTime < dist[nextNode]) {
                    dist[nextNode] = newTime;
                    ways[nextNode] = ways[node];
                    pq.offer(new long[]{newTime, nextNode});
                } else if (newTime == dist[nextNode]) {
                    ways[nextNode] = (ways[nextNode] + ways[node]) % MOD; 
                }
            }
        }
        return ways[n - 1];
    }
}