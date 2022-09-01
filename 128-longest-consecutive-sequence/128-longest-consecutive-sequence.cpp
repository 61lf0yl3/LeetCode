class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        int n = nums.size();
        unordered_set<int> set;
        for (int i = 0; i < n; i++) {
            set.insert(nums[i]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (set.find(nums[i]-1) == set.end()) {
                int count = 0;
                while (set.find(nums[i]+count) != set.end()) {
                    count++;
                }
                res = max(res, count);
            }
        }
        return res;
    }
};