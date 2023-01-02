class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        this->nums = nums;
        vector<int> comb;
        backtrack(comb, 0);
        return res;
    }
    
private:
    vector<vector<int>> res;
    vector<int> nums;
    
    void backtrack(vector<int>& comb, int start) {
        if (comb.size() == nums.size()) {
            res.push_back(comb);
        } else {
            for (int i = start; i < nums.size(); i++) {
                comb.push_back(nums[i]);
                
                int temp = nums[i];
                nums[i] = nums[start];
                nums[start] = temp;

                backtrack(comb, start+1);
                
                nums[start] = nums[i];
                nums[i] = temp;
                
                comb.pop_back();
            }
        }
    }
};


