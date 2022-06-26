class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        
        int[] right = new int[n];
        right[n-1] = 1;
        for (int i = n-2; i >= 0; i--) {
            right[i] = nums[i+1]*right[i+1];
        }
        int[] res = new int[n];
        res[0] = right[0];
        int left = 1;
        for (int i = 1; i < n; i++) {
            left *= nums[i-1];
            res[i]=left*right[i];
        }
        return res;
    }
}