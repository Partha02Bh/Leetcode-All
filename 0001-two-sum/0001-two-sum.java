class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        
        HashMap<Integer, Integer> mpp= new HashMap<>();

        for(int i=0;i<n;i++) {
            int sum =nums[i];
            int diff = target-sum;
            if(mpp.containsKey(diff)) {
                return new int[] {mpp.get(diff),i};
            }
            mpp.put(nums[i],i);
        }
        return null;
    }
}