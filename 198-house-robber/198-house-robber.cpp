class Solution {
public:
    int rob(vector<int>& nums) {
        this->nums = nums;
        return dfs(nums.size()-1);
    }
    
private: 
    vector<int> nums;
    unordered_map<int, int> memo;
    int dfs(int i) {
        if (i < 0) {
            return 0;
        }
        if (memo.find(i) == memo.end()) {
            memo[i] = max(dfs(i-2)+nums[i], dfs(i-1));
        }
        return memo[i];
    }    
};