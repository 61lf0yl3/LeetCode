class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int res = 0;
        int diff = Integer.MAX_VALUE;
        
        Arrays.sort(nums);
        for (int mid = 0; mid < nums.length; mid++) {
            int low = mid+1;
            int high = nums.length-1;
            while (low < high) {
                int sum = nums[low] + nums[mid] + nums[high];
                if (diff > Math.abs(target-sum)){
                    diff = Math.abs(target-sum);
                    res = sum;
                }
                if (sum > target) {
                    high--;
                } else {
                    low++;
                }
            }
        }
        return res;
    }
}