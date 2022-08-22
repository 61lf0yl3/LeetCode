class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> res (2);
        unordered_map<int, int> map;
        for (int i = 0; i < nums.size(); i++) {
            int find = target - nums[i];
            if (map.find(find) != map.end()) {
                res[0] = i;
                res[1] = map[find];
                break;
            } else {
                map.insert({nums[i], i});
            }
        }
        
        return res;
    }
};