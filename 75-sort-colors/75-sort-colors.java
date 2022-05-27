class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int curr = 0;
        
        while (curr <= high) {
            if (nums[curr]==0) {
                nums[curr++] = nums[low];
                nums[low++] = 0;
            } else if (nums[curr]==2) {
                nums[curr] = nums[high];
                nums[high--] = 2;
            } else {
                curr++;
            }
        }
    }
}