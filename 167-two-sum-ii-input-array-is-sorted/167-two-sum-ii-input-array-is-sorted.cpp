class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        int low = 0;
        int high = numbers.size()-1;
        vector<int> res;
        
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                res.push_back(low+1);
                res.push_back(high+1);
                break;
            } else if (sum < target) {
                low++;
            } else {
                high--;
            }
        }
        
        return res;
    }
};