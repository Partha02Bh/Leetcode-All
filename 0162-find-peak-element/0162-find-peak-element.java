class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;

            // If mid is less than its right neighbor, move right
            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else {
                // mid could be a peak, or a peak is on the left
                high = mid;
            }
        }

        // low == high → peak index found
        return low;
    }
}