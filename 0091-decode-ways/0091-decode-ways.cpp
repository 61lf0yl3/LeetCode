class Solution {
public:
    int numDecodings(string s) {
        this->s = s;
        return dfs(0);
    }
    
private:
    string s;
    unordered_map<int, int> memo;
    
    int dfs(int i) {
        if (i >= s.size()) {
            return 1;
        }
        // if contains
        if (memo.find(i) != memo.end()) {
            return memo[i];
        }
        if (s[i] == '0') {
            return 0;
        }
        if (i == s.size()-1) {
            return 1;
        }
        int res = dfs(i+1);
        if (stoi(s.substr(i, 2)) <= 26) {
            res += dfs(i+2);
        }
        memo[i] = res;
        return res;
    }

};