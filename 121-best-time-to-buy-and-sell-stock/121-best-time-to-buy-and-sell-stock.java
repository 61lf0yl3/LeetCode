class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int buy = 0;
        for (int sell = 0; sell < prices.length; sell++) {
            if (prices[buy] > prices[sell]) {
                buy = sell;
            } else {
                res = Math.max(res, prices[sell]-prices[buy]);
            }
        }
        return res;
    }
}