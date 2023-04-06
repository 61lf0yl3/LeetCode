class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        set<string> set_word(wordDict.begin(), wordDict.end());
        vector<int> memo(s.length(), -1);
        return dfs(0, s, set_word, memo);
    }
    
private:
    bool dfs(int start, string s, set<string>& set_word, vector<int>& memo) {
        if (start >= s.size()) {
            return true;
        }
        if (memo[start] != -1) {
            return memo[start];
        }
        for (int end = start; end < s.size(); end++) {
            if (set_word.find(s.substr(start, end+1-start)) != set_word.end() && 
                dfs(end+1, s, set_word, memo)) {
                return memo[start]=true;
            }
        }
        return memo[start]=false;
    }
};


