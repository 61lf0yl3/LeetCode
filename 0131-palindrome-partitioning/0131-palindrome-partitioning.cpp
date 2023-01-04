class Solution {
public: 
    vector<vector<string>> partition(string s) {
        this->s = s;
        vector<string> comb;
        backtrack(comb, 0);
        return res;
    }
    
private:
    vector<vector<string>> res;
    string s;
    void backtrack(vector<string> comb, int start) {
        if (start >= s.size()) {
            res.push_back(comb);
        }
        for (int i = start; i < s.size(); i++) {
            if (isPalindrome(start, i)) {
                comb.push_back(s.substr(start, i-start+1));
                backtrack(comb, i+1);
                comb.pop_back();
            }
        }
    }
    
    bool isPalindrome(int start, int end) {
        while (start < end) {
            if (s[start++] != s[end--]) {
                return false;
            }
        }
        return true;
    }
};