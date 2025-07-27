class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int ans=nums[0];
        int maxi=0;
        for(int i=0;i<n;i++){
            maxi+=nums[i];
            ans=maxi>ans? maxi:ans;
            if(maxi<0){
                maxi=0;
            }
        }
        return ans;
    }
}