class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int buy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i]-buy;
            buy = Math.min(buy, prices[i]);
            max = Math.max(max, profit);
        }
        
        return max;
    }
}


        // int profit = 0;
        // int sell = Integer.MAX_VALUE;
        // for (int price : prices) {
        //     int currProfit = price-sell;
        //     profit = Math.max(profit, currProfit);
        //     sell = Math.min(sell, price);
        // }
        // return profit;