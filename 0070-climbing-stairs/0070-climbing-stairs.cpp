class Solution {
public:
    int climbStairs(int n) {
        if (n==1) {
            return 1;
        }
        vector<int> memo;
        memo.push_back(1);
        memo.push_back(1);
        for (int i = 2; i <= n; i++) {
            memo.push_back(memo[i-1]+memo[i-2]);
        }
        return memo[n];
    }
};