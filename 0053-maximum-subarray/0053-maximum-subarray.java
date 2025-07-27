class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int maxi=nums[0];
        int ans=nums[0];
        for(int i=1;i<n;i++){
            maxi=Math.max(nums[i],maxi+nums[i]);
            ans=Math.max(ans,maxi);
        }
        return ans;
    }
}