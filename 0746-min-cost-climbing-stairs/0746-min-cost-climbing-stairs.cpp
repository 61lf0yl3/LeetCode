class Solution {
public:
    int minCostClimbingStairs(vector<int>& cost) {
        unordered_map<int, int> memo;
        for (int i = 2; i <= cost.size(); i++) {
            memo[i] = min(memo[i-1]+cost[i-1], memo[i-2]+cost[i-2]);
        }
        return memo[cost.size()];
    }
};