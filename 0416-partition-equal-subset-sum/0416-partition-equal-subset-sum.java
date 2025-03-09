class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int tSum = 0;
        for(int i=0;i<n;i++) {
            tSum+=nums[i];
        }

        if(tSum%2==1) {
            return false;
        }
        else{
            int k = tSum/2;
            boolean dp[][] = new boolean[n][k + 1];

            for(int i=0;i<n;i++) {
                dp[i][0] = true;
            }

            if(nums[0]<=k) {
                dp[0][nums[0]] = true;
            }

            for(int i=1;i<n;i++) {
                for(int t=1;t<=k;t++) {
                    boolean notTaken = dp[i - 1][t];
                    boolean taken = false;
                    if (nums[i] <= t) {
                        taken = dp[i - 1][t - nums[i]];
                    }

                    // Update the DP table for the current element and target sum
                    dp[i][t] = notTaken || taken;
                }
            }
            return dp[n-1][k];
        }
    }
}