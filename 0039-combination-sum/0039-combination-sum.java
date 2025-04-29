class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        sub(candidates, target, 0, ans, new ArrayList<>());
        return ans;
    }

    public void sub(int[] candidates, int target, int ind, List<List<Integer>> ans, List<Integer> ds) {
        if(ind == candidates.length) {
            if(target==0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if(candidates[ind]<= target) {
            ds.add(candidates[ind]);
            sub(candidates, target-candidates[ind], ind, ans, ds);
            ds.remove(ds.size()-1);
        }
        sub(candidates, target, ind+1, ans, ds);
    }
}