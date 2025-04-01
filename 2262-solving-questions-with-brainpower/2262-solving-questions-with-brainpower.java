class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1]; // DP array

        // Process questions from right to left
        for (int i = n - 1; i >= 0; i--) {
            int points = questions[i][0];
            int brainpower = questions[i][1];

            // Option 1: Solve current question
            long solve = points;
            if (i + brainpower + 1 < n) {
                solve += dp[i + brainpower + 1]; // Add points from future valid questions
            }

            // Option 2: Skip the question
            long skip = dp[i + 1];

            // Store the best choice
            dp[i] = Math.max(solve, skip);
        }

        return dp[0]; 
    }
}