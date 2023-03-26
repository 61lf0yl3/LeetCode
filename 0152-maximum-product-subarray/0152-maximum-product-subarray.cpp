class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int max_so_far = nums[0];
        int min_so_far = nums[0];
        int res = max_so_far;
        for (int i=1; i< nums.size(); i++) {
            int num = nums[i];
            int temp_max = max(num, max(max_so_far*num, min_so_far*num));
            min_so_far = min(num, min(max_so_far*num, min_so_far*num));
            
            max_so_far = temp_max;
            
            res = max(res, max_so_far);
        }
        return res;
    }
};