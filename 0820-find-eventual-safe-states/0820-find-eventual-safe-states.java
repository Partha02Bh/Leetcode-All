class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> reverseGraph = new ArrayList<>();
        int[] outDegree = new int[n];
        
        for (int i = 0; i < n; i++) {
            reverseGraph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n; i++) {
            for (int neighbor : graph[i]) {
                reverseGraph.get(neighbor).add(i);
            }
            outDegree[i] = graph[i].length;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (outDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        List<Integer> safeNodes = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            safeNodes.add(node);
            for (int neighbor : reverseGraph.get(node)) {
                outDegree[neighbor]--;
                if (outDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        Collections.sort(safeNodes);
        return safeNodes;
    }
}