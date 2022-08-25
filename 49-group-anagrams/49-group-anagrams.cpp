
class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> m;
        for (int i = 0; i < strs.size(); i++) {
            vector<int> chars(26);
            for (int j = 0; j < strs[i].size(); j++) {
                chars[strs[i][j]-'a']++;
            }
            string key = "";
            for (int j = 0; j < 26; j++) {
                key.append(to_string(chars[j]+'a'));
            }
            
            m[key].push_back(strs[i]);
        }
                           
        vector<vector<string>> res;
        for (auto i = m.begin(); i != m.end(); i++) {
            res.push_back(i->second);
        }
        return res;
    }
};