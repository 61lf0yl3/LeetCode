class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        vector<int> chars(26);
        for (int i = 0; i < s1.size(); i++) {
            chars[s1[i] -'a']++;
        }
        int left = 0;
        int right = 0;
        
        while (right < s2.size()) {
            int r = s2[right];
            if (chars[r-'a']==0) {
                chars[s2[left]-'a']++;
                left++;
                continue;
            } else {
                chars[r-'a']--;
                if (right-left+1==s1.size()) {
                    return true;
                }
            }
            right++;
        }
        return false;
    }
};