class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {      
        Map<Integer, Integer> m = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sum %= k;
            if (sum == 0 && i > 0) {
                return true;
            }
            if (m.containsKey(sum)) {
                if (i - m.get(sum) > 1) {
                    return true;
                }
            } else {
                m.put(sum, i);
            }

        }
        return false;
    }
}