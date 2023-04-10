class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        vector<int> memo(nums.size(), 1);
        int res = 1;
        for (int i = 0; i < nums.size(); i++) {
            dfs(nums, i, memo, res);
        }
        return res;
    }
private:
    int dfs(vector<int>& nums, int i, vector<int>& memo, int& res) {
        if (i > nums.size()) {
            return 0;
        }
        if (memo[i] != 1) {
            return memo[i];
        }
        for (int j = i; j < nums.size(); j++) {
            if (nums[j] > nums[i]) {
                memo[i] = max(memo[i], dfs(nums, j, memo, res)+1);
                res = max(res, memo[i]);
            }
        }
        return memo[i];
    }
};
