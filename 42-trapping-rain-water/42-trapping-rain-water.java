class Solution {
    public int trap(int[] height) {
        int n = height.length;
        
        int[] left = new int[n];
        int currMax = height[0];
        for (int i = 1; i < n; i++) {
            int volume = currMax - height[i];
            currMax = Math.max(currMax, height[i]);
            if (volume > 0) {
                left[i] = volume;
            }
        }
        
        int[] right = new int[n];
        currMax = height[n-1];
        for (int i = n-2; i >= 0; i--) {
            int volume = currMax - height[i];
            currMax = Math.max(currMax, height[i]);
            if (volume > 0) {
                right[i] = volume;
            }
        }
        int res = 0;
        for (int i = 1; i < n-1; i++) {
            res += Math.min(left[i], right[i]);
        }
        return res;
    }
}