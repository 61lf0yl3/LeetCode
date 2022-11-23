class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length; 
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                continue;
            }
            if (i > 0 && nums[i]==nums[i-1]) {
                continue;
            }
            int low = i+1;
            int high = n-1;
            while (low < high) {
                int sum = nums[i]+nums[low]+nums[high];
                if (sum<0) {
                    low++;
                } else if (sum>0) {
                    high--;
                } else {
                    res.add(Arrays.asList(nums[i], nums[low++], nums[high--]));
                    while (low < high && nums[low] == nums[low-1]) {
                        low++;
                    }
                }
            }
        }
        return res;
    }
}