class Solution {
public:
    int maxArea(vector<int>& height) {
        int low = 0;
        int high = height.size()-1;
        int res = 0;
        while (low < high) {
            int vol = min(height[low], height[high])*(high-low);
            res = max(res, vol);
            if (height[low] < height[high]) {
                low++;
            } else {
                high--;
            }
        }
        return res;
    }
};