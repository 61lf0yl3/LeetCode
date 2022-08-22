class Solution {
public:
    bool isAnagram(string s, string t) {
        if (s.size() != t.size()) {
            return false;
        }
        vector<int> chars(26);
        
        for (int i = 0; i < s.size(); i++) {
            chars[s[i]-'a']++;
            chars[t[i]-'a']--;
        }
        
        for (int n : chars) {
            if (n != 0) {
                return false;
            }
        }
        return true;
    }
};