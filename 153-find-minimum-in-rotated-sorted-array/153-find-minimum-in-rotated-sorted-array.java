class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        
        while (low < high) {
            int mid = low + (high-low)/2;
            if (mid < n-1 && nums[mid] > nums[mid+1]) {
                return nums[mid+1];
            }
            if (mid > 0 && nums[mid] < nums[mid-1]) {
                return nums[mid];
            }
            // up part
            if (nums[low] <= nums[mid]) {
                if (nums[mid] < nums[mid+1] && nums[high] < nums[mid]) {
                    low = mid+1;
                } else {
                    high--;
                }
            } else {
            // down part
                if (nums[mid]>nums[mid-1] && nums[mid] < nums[0]) {
                    high = mid-1;
                } else {
                    low++;
                }
            }
        }
        return nums[low];
    }
}