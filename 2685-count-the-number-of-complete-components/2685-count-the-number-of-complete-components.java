class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
         Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // Step 2: Find connected components using DFS
        boolean[] visited = new boolean[n];

        int completeCount = 0;

        for (int node = 0; node < n; node++) {
            if (!visited[node]) {
                List<Integer> component = new ArrayList<>();
                dfs(node, graph, visited, component);

                // Step 3: Check if the component is complete
                int k = component.size();
                int edgeCount = 0;

                for (int v : component) {
                    edgeCount += graph.get(v).size();
                }

                // Each edge is counted twice, so divide by 2
                if (edgeCount / 2 == (k * (k - 1)) / 2) {
                    completeCount++;
                }
            }
        }

        return completeCount;
    }
        private static void dfs(int node, Map<Integer, Set<Integer>> graph, boolean[] visited, List<Integer> component) {
        Stack<Integer> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            int curr = stack.pop();
            if (!visited[curr]) {
                visited[curr] = true;
                component.add(curr);
                for (int neighbor : graph.get(curr)) {
                    if (!visited[neighbor]) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }
}