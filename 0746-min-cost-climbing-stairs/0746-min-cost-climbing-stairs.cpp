class Solution {
public:
    int minCostClimbingStairs(vector<int>& cost) {
        this->cost = cost;
        return dfs(cost.size());
    }
    
private:
    vector<int> cost;
    unordered_map<int, int> memo;
    
    int dfs(int i) {
        if (i < 2) {
            return 0;
        }
        if (memo.find(i) == memo.end()) {
            memo[i] = min(dfs(i-1)+cost[i-1], dfs(i-2)+cost[i-2]);
        }
        return memo[i];
    }
};