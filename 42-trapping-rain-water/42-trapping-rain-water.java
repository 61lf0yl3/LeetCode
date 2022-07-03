class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int res = 0;
        int left = 0;
        int leftMax = height[left];
        int right = n-1;
        int rightMax = height[right];
        while (left < right) {
            if (height[left] < height[right]) {
                res+= leftMax > height[left] ? leftMax-height[left] : 0;
                leftMax = Math.max(leftMax, height[left]);
                left++;
            } else {
                res+= rightMax > height[right] ? rightMax-height[right]:0;
                rightMax = Math.max(rightMax, height[right]);
                right--;
            }
        }
        return res;
    }
}