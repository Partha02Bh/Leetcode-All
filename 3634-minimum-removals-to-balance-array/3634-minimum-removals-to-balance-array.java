class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);

        int removals = 0;
        for (long num: nums)
            removals += (num > (long) nums[removals] * k) ? 1 : 0;

        return removals;
    }
}