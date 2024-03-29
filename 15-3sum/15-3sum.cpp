class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        int n = nums.size();
        sort(nums.begin(), nums.end());
        vector<vector<int>> res;
        for (int i = 0; i < n-2; i++) {
            if (nums[i] > 0) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int low = i+1;
            int high = n-1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (sum == 0) {
                    res.push_back({nums[i], nums[low], nums[high]});
                    while (low < high && nums[low] == nums[low+1]) {
                        low++;
                    }
                    low++;
                    while (low < high && nums[high] == nums[high-1]) {
                        high--;
                    }
                    high--;
                } else if (sum < 0) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return res;
    }
};