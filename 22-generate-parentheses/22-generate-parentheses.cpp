class Solution {
public:
    vector<string> generateParenthesis(int n) {
        vector<string> res;
        backtrack(n, res, 0, 0, "");
        return res;
    }

private:
    void backtrack(int n, vector<string>& res, int open, int close, string comb) {
        if (comb.size() == 2*n) {
            res.push_back(comb);
            return;
        }
        if (open < n) {
            backtrack(n, res, open+1, close, comb+'(');
        }
        if (close < open) {
            backtrack(n, res, open, close+1, comb+')');
        }
    }
    
};