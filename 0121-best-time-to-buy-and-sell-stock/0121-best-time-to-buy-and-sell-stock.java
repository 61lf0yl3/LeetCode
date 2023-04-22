class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int sell = Integer.MAX_VALUE;
        for (int price : prices) {
            int currProfit = price-sell;
            profit = Math.max(profit, currProfit);
            sell = Math.min(sell, price);
        }
        return profit;
    }
}