class Solution {
public:
    vector<int> candidates;
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        this->candidates = candidates;
        vector<int> comb; 
        backtrack(comb, target, 0);
        return res;
    }
    
private:
    vector<vector<int>> res;
    void backtrack(vector<int>& comb, int target, int start) {
        if (target == 0) {
            res.push_back(comb);
        } else if (target > 0) {
            for (int i = start; i < candidates.size(); i++) {
                comb.push_back(candidates[i]);
                backtrack(comb, target-candidates[i], i);
                comb.pop_back();
            }
        }
    }
    
};
