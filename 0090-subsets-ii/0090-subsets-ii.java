class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        subsetSumsHelper(0,nums,ans, new ArrayList<>());
        return ans;
    }
    public static void subsetSumsHelper(int ind, int[] nums, List<List<Integer>> ans, List<Integer> ds) {
        ans.add(new ArrayList<>(ds));
        for(int i=ind;i<nums.length;i++) {
            if(i!=ind && nums[i]==nums[i-1]) continue;
            ds.add(nums[i]);
            subsetSumsHelper(i+1,nums,ans,ds);
            ds.remove(ds.size()-1);
        }
    }
}