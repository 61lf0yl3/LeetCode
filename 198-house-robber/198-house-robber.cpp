class Solution {
public:
    int rob(vector<int>& nums) {
        int n = nums.size();
        unordered_map<int, int> memo;
        memo[n-1] = nums[n-1];
        for (int i = n-2; i >= 0; i--) {
            memo[i] = max(memo[i+2]+nums[i], memo[i+1]);
        }
        
        return memo[0];
    }  
};