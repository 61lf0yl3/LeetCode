class Solution {
public:
    int numDecodings(string s) {
        int n = s.size();
        vector<int> dp(n+1);
        dp[0] = 1;
        dp[1] = s[0] == '0' ? 0 : 1;
        
        for (int i = 2; i < dp.size(); i++) {
            if (s[i-1] != '0') {
                dp[i] += dp[i-1];
            }
            int twodigit = stoi(s.substr(i-2, 2));
            if (10 <= twodigit && twodigit <= 26) {
                dp[i] += dp[i-2];
            }
        }
        
        return dp[n];
    }
};