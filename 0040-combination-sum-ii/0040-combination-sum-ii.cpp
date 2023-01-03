class Solution {
public:
    vector<int> candidates;
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end());
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
                if (i != start && candidates[i-1]==candidates[i]) {
                    continue;
                }
                comb.push_back(candidates[i]);
                backtrack(comb, target-candidates[i], i+1);
                comb.pop_back();
            }
        }
    }
    
};

