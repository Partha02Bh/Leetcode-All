class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++) {
            adj.add(new ArrayList<>());
        }

        for(int time[]: times) {
            adj.get(time[0]).add(new int[] {time[1], time[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0,k});

        int dist[] = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        while(!pq.isEmpty()) {
            int curr[] = pq.poll();
            int time = curr[0];
            int node = curr[1];

            if(time > dist[node])   continue;
            for(int ngh[]: adj.get(node)) {
                int nextNode = ngh[0];
                int travelTime = ngh[1];

                int newTime = time + travelTime;
                if(newTime < dist[nextNode]) {
                    dist[nextNode] = newTime;
                    pq.add(new int[] {newTime, nextNode});
                }
            }
        }

        int maxTime = 0;
        for(int i=1;i<=n;i++) {
            if(dist[i] == Integer.MAX_VALUE)    return -1;
            maxTime = Math.max(maxTime, dist[i]);
        }
        return maxTime;
    }
}