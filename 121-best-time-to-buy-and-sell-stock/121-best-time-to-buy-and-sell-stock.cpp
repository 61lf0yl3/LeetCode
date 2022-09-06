class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        int res = 0;
        int min2 = prices[0];
        for (int i = 0; i < n; i++) {
            min2 = min(min2, prices[i]);
            res = max(res, prices[i]-min2);
        }
        return res;
    }
    
};