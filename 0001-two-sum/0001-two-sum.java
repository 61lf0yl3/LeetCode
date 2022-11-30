class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int key = target-nums[i];
            if (m.containsKey(key) && i!=m.get(key)) {
                return new int[]{i, m.get(key)};
            }
            m.put(nums[i], i);
        }
        return null;
    }
}