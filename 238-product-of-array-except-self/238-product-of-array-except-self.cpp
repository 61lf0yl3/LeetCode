class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int n = nums.size();
        vector<int> left(n);
        left[0] = 1;
        vector<int> right(n);
        right[n-1] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = nums[i-1]*left[i-1];
            right[n-i-1] = nums[n-i]*right[n-i];
        }
        
        vector<int> res(n);
        for (int i = 0; i < n; i++) {
            res[i] = left[i]*right[i];
        }
        return res;
    }
};