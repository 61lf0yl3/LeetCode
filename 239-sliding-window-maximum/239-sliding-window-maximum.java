class Solution {
         public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        
        int[] left = new int[n];
        left[0] = nums[0];
        int[] right = new int[n];
        right[n-1] = nums[n-1];
        for (int i = 1; i < n; i++) {
            if (i%k == 0) {
                left[i] = nums[i];
            } else {
                left[i] = Math.max(nums[i], left[i-1]);
            }
            
            int j = n-i-1;
            if ((j+1)%k == 0) {
                right[j] = nums[j];
            } else {
                right[j] = Math.max(nums[j], right[j+1]);
            }
        }
        
        int[] res = new int[n-k+1];
        for (int i = 0; i < res.length; i++) {
            res[i] = Math.max(left[i+k-1], right[i]);
        }
        return res;
    }
}