class Solution {
    public int maxProduct(int[] nums) {
        int max_so_far = nums[0];
        int min_so_far = nums[0];
        int res = max_so_far;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int temp_max = Math.max(num, Math.max(max_so_far*num, min_so_far*num));
            min_so_far = Math.min(num, Math.min(max_so_far*num, min_so_far*num));
            
            max_so_far = temp_max;
            
            res = Math.max(res, max_so_far);
        }
        return res;
    }
}