public class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        long count = 0;
        int left = 0;
        int maxCount = 0;

        for (int right = 0; right < n; right++) {
            if (nums[right] == maxVal) {
                maxCount++;
            }

            // Shrink the window until maxCount >= k
            while (maxCount >= k) {
                // Add subarrays ending at right with left index i ∈ [left, right]
                count += n - right; // All subarrays [left...right], [left...right+1], ...
                if (nums[left] == maxVal) {
                    maxCount--;
                }
                left++;
            }
        }

        return count;
    }
}
