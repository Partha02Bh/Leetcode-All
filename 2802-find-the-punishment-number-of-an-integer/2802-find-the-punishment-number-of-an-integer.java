class Solution {
    public int punishmentNumber(int n) {
        int ans = 0;
        for(int i=1;i<=n;i++) {
            int sq = i*i;
            String sqs = String.valueOf(sq);
            if(compatiable(sqs, i, 0, 0)) {
                ans+=sq;
            }
        }
        return ans;
    }
    
    private boolean compatiable(String str, int target, int index, int currSum) {
        if(currSum > target) {
            return false;
        }
        if(index== str.length()) {
            return currSum==target;
        }

        for(int end = index+1; end<=str.length(); end++) {
            int num = Integer.parseInt(str.substring(index, end));
            if(compatiable(str, target, end, currSum+num)) {
                return true;
            }
        }
        return false;
    }
}