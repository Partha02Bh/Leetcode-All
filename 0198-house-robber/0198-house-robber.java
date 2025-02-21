class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return solve(n, nums, dp);
    }

    private int solve(int n, int arr[], int dp[]) {
        dp[0] = arr[0];

        for(int i=1;i<n;i++) {
            int pick = arr[i];
            if(i>1) {
                pick+=dp[i-2];
            }
            int nPick = dp[i-1];
            dp[i] = Math.max(pick, nPick);
        }
        return dp[n-1];
    }
}