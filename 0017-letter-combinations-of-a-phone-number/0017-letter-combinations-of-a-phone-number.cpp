class Solution {
public:
    vector<string> letterCombinations(string digits) {
        if (digits.size()==0) {
            return res;
        }
        this->digits = digits;
        string comb;
        backtrack(0, comb);
        return res;
    }
private:
    unordered_map<char, string> letters = {
    {'2', "abc"},
    {'3', "def"},  
    {'4', "ghi"},
    {'5', "jkl"}, 
    {'6', "mno"},
    {'7', "pqrs"},
    {'8', "tuv"},
    {'9', "wxyz"}};
    vector<string> res;
    string digits;
    void backtrack(int i, string& comb) {
        if (i >= digits.size()) {
            res.push_back(comb);
            return; 
        }
        for (char c : letters[digits[i]]) {
            comb.push_back(c);
            backtrack(i+1, comb);
            comb.pop_back();
        }
    }
    
};


