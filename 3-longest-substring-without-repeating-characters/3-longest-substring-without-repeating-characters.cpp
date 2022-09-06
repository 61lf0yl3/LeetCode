class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int low = 0;
        int high = 0;
        int res = 0;
        vector<int> chars(128);
        while (high < s.size()) {
            if (chars[s[high]] > 0) {
                chars[s[low++]]--;
            } else {
                chars[s[high]]++;
                res = max(res, high++-low+1); 
            }
        }
        return res;
    }
};