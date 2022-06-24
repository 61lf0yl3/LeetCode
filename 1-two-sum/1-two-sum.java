class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            m.put(nums[i], i);
        }
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int key = target-nums[i];
            if (m.containsKey(key) && i!=m.get(key)) {
                return new int[]{i, m.get(key)};
            }
        }
        return null;
    }
}