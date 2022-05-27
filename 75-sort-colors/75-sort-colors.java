class Solution {
    public void sortColors(int[] nums) {
        final int RED = 0;
        final int WHITE = 1;
        final int BLUE = 2;
        int low = 0;
        int high = nums.length-1;
        int curr = 0;
        
        while (curr <= high) {
            if (nums[curr]==RED) {
                nums[curr++] = nums[low];
                nums[low++] = RED;
            } else if (nums[curr]==BLUE) {
                nums[curr] = nums[high];
                nums[high--] = BLUE;
            } else {
                curr++;
            }
        }
    }
}