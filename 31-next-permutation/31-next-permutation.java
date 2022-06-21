class Solution {
    public void nextPermutation(int[] nums) {
        int start = nums.length-2;
        while (start >= 0 && nums[start] >= nums[start+1]) {
            start--;
        }
        
        if (start >= 0) {
            int j = nums.length-1;
            while (nums[start] >= nums[j]) {
                j--;
            }
            swap(nums, start, j);
        }
        
        start++;
        int end = nums.length-1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}