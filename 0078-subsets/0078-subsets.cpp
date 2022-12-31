class Solution {
public:
    vector<vector<int>> res;
    vector<int> nums;
    vector<vector<int>> subsets(vector<int>& nums) {
        this->nums = nums;
        for (int i = 0; i <= nums.size(); i++) {
            vector<int> comb;
            backtrack(comb, i, 0);
        }
        return res;
    }
    
    void backtrack(vector<int>& comb, int size, int i) {
        if (size == comb.size()) {
            res.push_back(comb);
            return;
        } else {
            for (int j = i; j < nums.size(); j++) {
                comb.push_back(nums[j]);
                backtrack(comb, size, j+1);
                comb.pop_back();
            }
        }
    }
};