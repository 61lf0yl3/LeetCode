class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        this->coins = coins;
        return dp(amount);
    }
    
private:
    unordered_map<int, int> memo;
    vector<int> coins;
    int dp(int i) {
        if (i < 0) {
            return -1;
        }
        if (i == 0) {
            return 0;
        }
        if (memo.find(i) != memo.end()) {
            return memo[i];
        }
        int ret = INT_MAX;
        for (int j = 0; j < coins.size(); j++) {
            int coin = coins[j];
            int temp = dp(i-coin);
            if (temp != -1) {
                ret = min(ret, temp+1);
            }
        }
        if (ret == INT_MAX) {
            ret = -1;
        }
        memo[i] = ret;
        return memo[i];
    }
};