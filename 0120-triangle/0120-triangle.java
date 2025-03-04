class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
         int n = triangle.size();
        int[] dp = new int[n];

        // Initialize dp array with the last row of the triangle
        for (int j = 0; j < n; j++) {
            dp[j] = triangle.get(n - 1).get(j);
        }

        // Bottom-up DP approach
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }

        return dp[0]; 
    }
}