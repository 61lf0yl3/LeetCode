class Solution {
public:
    int characterReplacement(string s, int k) {
        int res = 0;
        int left = 0;
        int right = 0;
        vector<int> chars(26);
        int mostFregChar = 0;
        while (right < s.size()) {
            chars[s[right]-'A']++;
            mostFregChar = max(mostFregChar, chars[s[right]-'A']);
            if (right-left+1-mostFregChar <= k) {
                res = max(res, right-left+1);
            } else {
                chars[s[left++]-'A']--;
            }
            right++;
        }
        return res;
    }
};