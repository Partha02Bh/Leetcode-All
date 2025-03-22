class Solution {
    public int change(int amount, int[] arr) {
        int n = arr.length;
        int dp[][] = new int[n][amount + 1];
        for (int i = 0; i <=amount ; i++) {
            if (i % arr[0] == 0)
                dp[0][i] = 1;
        }

        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= amount; target++) {
                int notTaken = dp[ind - 1][target];

                int taken = 0;
                if (arr[ind] <= target)
                    taken = dp[ind][target - arr[ind]];

                dp[ind][target] = notTaken + taken;
            }
        }

        return dp[n - 1][amount];
    }
}