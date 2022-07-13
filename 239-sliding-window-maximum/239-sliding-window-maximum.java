class Solution {
     public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        left[0] = nums[0];
        right[n-1] = nums[n-1];
        for (int i = 1; i < nums.length; i++) {
            // from left to right
            if (i%k==0) { // block_start
                left[i] = nums[i];
            } else {
                left[i] = Math.max(left[i-1], nums[i]);
            }
            
            // from right to left
            int j = n-i-1;
            if (j % k == 0) { // block_start
                right[j] = nums[j];
            } else {
                right[j] = Math.max(right[j+1], nums[j]);
            }
        }
        
        int[] res = new int[n-k+1];
        for (int i = 0; i < n-k+1; i++) {
            res[i] = Math.max(right[i], left[i+k-1]);
        }
        return res;
    }
}