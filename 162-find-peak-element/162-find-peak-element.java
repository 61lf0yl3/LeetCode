class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        
        while (low < high) {
            int mid = low + (high-low)/2;
            long left = (long)nums[mid]-1;
            if (mid > 0) {
                left = nums[mid-1];
            }
            long right = (long)nums[mid]+1;
            if (mid < nums.length-1) {
                right = nums[mid+1];
            }
            if (left < nums[mid] && right < nums[mid] ) {
                return mid;
            } else if (left < right) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return low;
    }
}