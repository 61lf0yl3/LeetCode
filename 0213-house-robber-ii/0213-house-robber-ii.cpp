class Solution {
public:
    int rob(vector<int>& nums) {
        if (nums.size() == 1) {
            return nums[0];
        }
        this->nums = nums;
        unordered_map<int, int> memo;
        int max1 = dfs(memo, 1, nums.size()-1);
        memo.clear();
        int max2 = dfs(memo, 0, nums.size()-2);
        return max(max1, max2);
    }
    
private: 
    vector<int> nums;
    int dfs(unordered_map<int, int>& memo, int start, int i) {
        if (i < start) {
            return 0;
        }
        if (memo.find(i) == memo.end()) {
            memo[i] = max(dfs(memo, start, i-2)+nums[i], dfs(memo, start, i-1));
        }
        return memo[i];
    }    
};