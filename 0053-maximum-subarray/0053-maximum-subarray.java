class Solution {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int max = 0;
        for(int i=0;i<nums.length;i++) {
            max+=nums[i];

            ans = max>ans ? max:ans;
            if(max<0) {
                max=0;
            }
        }
        return ans;
    }
}