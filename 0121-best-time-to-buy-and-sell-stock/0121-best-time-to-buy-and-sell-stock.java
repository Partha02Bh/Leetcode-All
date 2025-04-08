class Solution {
    public int maxProfit(int[] prices) {
        int maxv = 0;
        int minv = Integer.MAX_VALUE;

        for(int i=0;i<prices.length;i++) {
            minv = Math.min(minv, prices[i]);
            maxv = Math.max(maxv, prices[i]-minv);
        }
        return maxv;
    }
}